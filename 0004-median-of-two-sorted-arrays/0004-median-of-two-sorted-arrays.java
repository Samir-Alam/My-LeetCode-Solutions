class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int na = A.length, nb = B.length;
        int n = na + nb;
        if ((na + nb) % 2 == 1)
            return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
        else
            return (double)(solve(A, B, n / 2, 0, na - 1, 0, nb - 1) + solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) / 2;
    }
    public int solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        if (aEnd < aStart)
            return B[k - aStart];
        if (bEnd < bStart)
            return A[k - bStart];
        int aIndex = (aStart + aEnd) / 2, bIndex = (bStart + bEnd) / 2;
        int aValue = A[aIndex], bValue = B[bIndex];
        if (aIndex + bIndex < k) { 
            if (aValue > bValue)
                return solve(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            else
                return solve(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
        } 
        else { 
            if (aValue > bValue)
                return solve(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            else
                return solve(A, B, k, aStart, aEnd, bStart, bIndex - 1);       
        }
    }
}