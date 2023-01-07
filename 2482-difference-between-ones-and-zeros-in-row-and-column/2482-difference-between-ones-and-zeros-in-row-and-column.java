class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int ans[][] = new int[row][col];
        int r[] = new int[row];
        int c[] = new int[col];
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                r[i] += grid[i][j];
        for(int i = 0; i < col; i++)
            for(int j = 0; j < row; j++)
                c[i] += grid[j][i];
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                ans[i][j]  = r[i] - (row - r[i]) + c[j] - (col - c[j]);
        return ans;
    }
}