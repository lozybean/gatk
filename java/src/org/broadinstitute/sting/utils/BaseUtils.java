package org.broadinstitute.sting.utils;

/**
 * BaseUtils contains some basic utilities for manipulating nucleotides.
 *
 * @author Kiran Garimella
 */
public class BaseUtils {
    /** Private constructor.  No instantiating this class! */
    private BaseUtils() {}
    
    /**
     * Converts a simple base to a base index
     *
     * @param base  [AaCcGgTt]
     * @return 0, 1, 2, 3, or -1 if the base can't be understood
     */
    static public int simpleBaseToBaseIndex(char base) {
        switch (base) {
            case 'A':
            case 'a': return 0;

            case 'C':
            case 'c': return 1;

            case 'G':
            case 'g': return 2;

            case 'T':
            case 't': return 3;

            default: return -1;
        }
    }

    /**
     * Converts a base index to a simple base
     *
     * @param baseIndex  0, 1, 2, 3
     * @return A, C, G, T, or '.' if the index can't be understood
     */
    static public char baseIndexToSimpleBase(int baseIndex) {
        switch (baseIndex) {
            case 0: return 'A';
            case 1: return 'C';
            case 2: return 'G';
            case 3: return 'T';
            default: return '.';
        }
    }

    /**
     * Converts a base index to a base index representing its cross-talk partner
     *
     * @param baseIndex  0, 1, 2, 3
     * @return 1, 0, 3, 2, or -1 if the index can't be understood
     */
    static public int crossTalkPartnerIndex(int baseIndex) {
        switch (baseIndex) {
            case 0: return 1; // A -> C
            case 1: return 0; // C -> A
            case 2: return 3; // G -> T
            case 3: return 2; // T -> G
            default: return -1;
        }
    }

    /**
     * Converts a base to the base representing its cross-talk partner
     *
     * @param base  [AaCcGgTt]
     * @return C, A, T, G, or '.' if the base can't be understood
     */
    static public char crossTalkPartnerBase(char base) {
        return baseIndexToSimpleBase(crossTalkPartnerIndex(simpleBaseToBaseIndex(base)));
    }

    /**
     * Return the complement of a base index.
     *
     * @param baseIndex  the base index (0:A, 1:C, 2:G, 3:T)
     * @return the complementary base index
     */
    static public byte complementIndex(int baseIndex) {
        switch (baseIndex) {
            case 0: return 3; // a -> t
            case 1: return 2; // c -> g
            case 2: return 1; // g -> c
            case 3: return 0; // t -> a
            default: return -1; // wtf?
        }
    }

    /**
     * Return the complement of a base.
     *
     * @param base  the base [AaCcGgTt]
     * @return the complementary base
     */
    static public byte simpleComplement(char base) {
        switch (base) {
            case 'A':
            case 'a': return 'T';
            case 'C':
            case 'c': return 'G';
            case 'G':
            case 'g': return 'C';
            case 'T':
            case 't': return 'A';
            default: return '.';
        }
    }

    /**
     * Reverse complement a byte array of bases
     * @param bases  the byte array of bases
     * @return the reverse complement of the base byte array
     */
    static public byte[] simpleReverseComplement(byte[] bases) {
        byte[] rcbases = new byte[bases.length];

        for (int i = 0; i < bases.length; i++) {
            rcbases[i] = simpleComplement((char) bases[bases.length - 1]);
        }

        return rcbases;
    }

    /**
     * Reverse a byte array of bases
     * @param bases  the byte array of bases
     * @return the reverse of the base byte array
     */
    static public byte[] reverse(byte[] bases) {
        byte[] rcbases = new byte[bases.length];

        for (int i = 0; i < bases.length; i++) {
            rcbases[i] = bases[bases.length - 1];
        }

        return rcbases;
    }
}
