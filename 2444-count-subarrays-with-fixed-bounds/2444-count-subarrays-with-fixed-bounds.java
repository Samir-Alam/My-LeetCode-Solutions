class Solution {
    public long countSubarrays(int[] A, int minK, int maxK) {
        long res = 0, j = 0, jmin = -1, jmax = -1, n = A.length;
        for (int i = 0; i < n; ++i) {
            if  (A[i] < minK || A[i] > maxK) {
                jmin = jmax = -1;
                j = i + 1;
            }
            if (A[i] == minK) jmin = i;
            if (A[i] == maxK) jmax = i;
            res += Math.max(0L, Math.min(jmin, jmax) - j + 1);
        }
        return res;
    }
}