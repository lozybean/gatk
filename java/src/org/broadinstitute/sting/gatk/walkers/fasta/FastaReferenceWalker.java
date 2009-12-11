package org.broadinstitute.sting.gatk.walkers.fasta;

import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.RefWalker;
import org.broadinstitute.sting.gatk.walkers.WalkerName;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.GenomeLocParser;
import org.broadinstitute.sting.utils.Pair;
import org.broadinstitute.sting.utils.cmdLine.Argument;

/**
 * Renders a new reference in FASTA format consisting of only those loci provided in the input data set.  Has optional
 * features to control the output format.
 */
@WalkerName("FastaReferenceMaker")
public class FastaReferenceWalker extends RefWalker<Pair<GenomeLoc, String>, GenomeLoc> {
    @Argument(fullName="lineWidth", shortName="lw", doc="Maximum length of sequence to write per line", required=false) public int fastaLineWidth=60;
    @Argument(fullName="rawOnelineSeq", shortName="raw", doc="Print sequences with no FASTA header lines, one line per interval (i.e. lineWidth = infinity) - CAUTION: adjacent intervals will automatically be merged", required=false) public boolean fastaRawSeqs=false;

    protected FastaSequence fasta;

    public void initialize() {
        if (fastaRawSeqs) fastaLineWidth = Integer.MAX_VALUE;
        fasta = new FastaSequence(out, fastaLineWidth, fastaRawSeqs);
    }

	public Pair<GenomeLoc, String> map(RefMetaDataTracker rodData, ReferenceContext ref, AlignmentContext context) {
        return new Pair<GenomeLoc, String>(context.getLocation(), String.valueOf(ref.getBase()));
	}

    public GenomeLoc reduceInit() {
        return null;
    }

	public GenomeLoc reduce(Pair<GenomeLoc, String> value, GenomeLoc sum) {
        if ( value == null )
            return sum;

        // if there is no interval to the left, then this is the first one
        if ( sum == null ) {
            sum = value.first;
            fasta.append(value.second.toString());
        }
        // if the intervals don't overlap, print out the leftmost one and start a new one
        // (end of contig or new interval)
        else if ( value.first.getStart() != sum.getStop() + 1 ) {
            fasta.flush();
            sum = value.first;
            fasta.append(value.second.toString());
        }
        // otherwise, merge them
        else {
            sum = GenomeLocParser.setStop(sum, value.first.getStop());
            fasta.append(value.second.toString());
        }
		return sum;
	}

    public void onTraversalDone(GenomeLoc sum) {
        fasta.flush();
    }
}