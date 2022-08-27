class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < m; ++r1) {
            int[] arr = new int[n]; // arr[i] is sum(matrix[r1][c]...matrix[r2][c])
            for (int r2 = r1; r2 < m; ++r2) {
                for (int c = 0; c < n; ++c) arr[c] += matrix[r2][c];
                ans = Math.max(ans, maxSumSubArray(arr, n, k));
            }
        }
        return ans;
    }
    int maxSumSubArray(int[] arr, int n, int k) { // O(N * logN)
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        int ans = Integer.MIN_VALUE;
        for (int i = 0, right = 0; i < n; ++i) {
            right += arr[i];
            Integer left = bst.ceiling(right - k); // right - left <= k -> left >= right - k
            if (left != null) {
                ans = Math.max(ans, right - left);
            }
            bst.add(right);
        }
        return ans;
    }
}