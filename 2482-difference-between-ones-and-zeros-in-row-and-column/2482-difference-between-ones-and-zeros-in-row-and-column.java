class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        // int row = grid.length, col = grid[0].length;
        // int ans[][] = new int[row][col];
        // int r[] = new int[row];
        // int c[] = new int[col];
        // for(int i = 0; i < row; i++)
        //     for(int j = 0; j < col; j++)
        //         r[i] += grid[i][j];
        // for(int i = 0; i < col; i++)
        //     for(int j = 0; j < row; j++)
        //         c[i] += grid[j][i];
        // for(int i = 0; i < row; i++)
        //     for(int j = 0; j < col; j++)
        //         ans[i][j]  = r[i] - (row - r[i]) + c[j] - (col - c[j]);
        // return ans;
        
        int R = grid.length, C = grid[0].length;
        int[] row = new int[R], col = new int[C]; 
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int offset = 2 * grid[r][c] - 1; // grid[r][c] = 1: 1, grid[r][c] = 0: -1.
                row[r] += offset;
                col[c] += offset;
            }
        }
        int[][] ans = new int[R][C];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                ans[r][c] = row[r] + col[c];
            }
        }
        return ans;
    }
}