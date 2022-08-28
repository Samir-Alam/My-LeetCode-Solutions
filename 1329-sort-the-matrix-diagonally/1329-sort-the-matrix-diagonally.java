class Solution {
    public int[][] diagonalSort(int[][] mat) {
        // int m = A.length, n = A[0].length;
        // HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j) {
        //         d.putIfAbsent(i - j, new PriorityQueue<>());
        //         d.get(i - j).add(A[i][j]);
        //     }
        // }
        // for (int i = 0; i < m; ++i)
        //     for (int j = 0; j < n; ++j)
        //         A[i][j] = d.get(i - j).poll();
        // return A;
        
        int m = mat.length, n = mat[0].length;
        for (int r = m - 1, c = 0; r >= 0; r--) fillMatrix(mat, m, n, r, c);
        for (int r = 0, c = 1; c < n - 1; c++) fillMatrix(mat, m, n, r, c);
        return mat;
    }
    private void fillMatrix(int[][] mat, int m, int n, int r, int c) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; r + i < m && c + i < n; i++) arr.add(mat[r + i][c + i]);
        Collections.sort(arr);
        for (int i = 0; r + i < m && c + i < n; i++) mat[r + i][c + i] = arr.get(i);
    }
}