/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM */

#ifndef _Included_org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM
#define _Included_org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM
#ifdef __cplusplus
extern "C" {
#endif
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_TRISTATE_CORRECTION
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_TRISTATE_CORRECTION 3.0
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_matchToMatch
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_matchToMatch 0L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_indelToMatch
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_indelToMatch 1L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_matchToInsertion
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_matchToInsertion 2L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_insertionToInsertion
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_insertionToInsertion 3L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_matchToDeletion
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_matchToDeletion 4L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_deletionToDeletion
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_deletionToDeletion 5L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug 0L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_verify
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_verify 0L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug0_1
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug0_1 0L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug1
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug1 0L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug2
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug2 0L
#undef org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug3
#define org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_debug3 0L
/*
 * Class:     org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM
 * Method:    jniInitialize
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_jniInitialize
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM
 * Method:    jniInitializeProbabilities
 * Signature: ([[D[B[B[B)V
 */
JNIEXPORT void JNICALL Java_org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_jniInitializeProbabilities
  (JNIEnv *, jclass, jobjectArray, jbyteArray, jbyteArray, jbyteArray);

/*
 * Class:     org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM
 * Method:    jniInitializePriorsAndUpdateCells
 * Signature: (ZII[B[B[BI)D
 */
JNIEXPORT jdouble JNICALL Java_org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_jniInitializePriorsAndUpdateCells
  (JNIEnv *, jobject, jboolean, jint, jint, jbyteArray, jbyteArray, jbyteArray, jint);

/*
 * Class:     org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM
 * Method:    jniSubComputeReadLikelihoodGivenHaplotypeLog10
 * Signature: (II[B[B[B[B[B[BI)D
 */
JNIEXPORT jdouble JNICALL Java_org_broadinstitute_sting_utils_pairhmm_DebugJNILoglessPairHMM_jniSubComputeReadLikelihoodGivenHaplotypeLog10
  (JNIEnv *, jobject, jint, jint, jbyteArray, jbyteArray, jbyteArray, jbyteArray, jbyteArray, jbyteArray, jint);

#ifdef __cplusplus
}
#endif
#endif
