class Solution {
    public int[] findBall(int[][] grid) {
        // int result[] = new int[grid[0].length];
        // for (int i = 0; i < grid[0].length; i++)
        //     result[i] = findBallDropColumn(0, i, grid);
        // return result;
        
        //2nd Solution
        // int m = grid.length, n = grid[0].length, res[] = new int[n];
        // for (int i = 0; i < n; ++i) {
        //     int i1 = i, i2;
        //     for (int j = 0; j < m; ++j) {
        //         i2 = i1 + grid[j][i1];
        //         if (i2 < 0 || i2 >= n || grid[j][i2] != grid[j][i1]) {
        //             i1 = -1;
        //             break;
        //         }
        //         i1 = i2;
        //     }
        //     res[i] = i1;
        // }
        // return res;
        
        //DP solution
        int result[] = new int[grid[0].length];
        Integer memo[][] = new Integer[grid.length + 1][grid[0].length];
        for (int row = grid.length; row >= 0; row--)
            for (int col = 0; col < grid[0].length; col++) {
                if (row == grid.length) {
                    memo[row][col] = col;
                    continue;
                }
                int nextColumn = col + grid[row][col];
                if (nextColumn < 0 ||
                        nextColumn > grid[0].length - 1 ||
                        grid[row][col] != grid[row][nextColumn])
                    memo[row][col] = -1;
                else
                    memo[row][col] = memo[row + 1][nextColumn];
                if (row == 0)
                    result[col] = memo[row][col];
            }
        return result;
    }
    // public int findBallDropColumn(int row, int col, int[][] grid) {
    //     if (row == grid.length)
    //         return col;
    //     int nextColumn = col + grid[row][col];
    //     if (nextColumn < 0 ||
    //             nextColumn > grid[0].length - 1 ||
    //             grid[row][col] != grid[row][nextColumn])
    //         return -1;
    //     return findBallDropColumn(row + 1, nextColumn, grid);
    // }
}