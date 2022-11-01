class Solution {
    public int[] findBall(int[][] grid) {
        // int result[] = new int[grid[0].length];
        // for (int i = 0; i < grid[0].length; i++)
        //     result[i] = findBallDropColumn(0, i, grid);
        // return result;
        int m = grid.length, n = grid[0].length, res[] = new int[n];
        for (int i = 0; i < n; ++i) {
            int i1 = i, i2;
            for (int j = 0; j < m; ++j) {
                i2 = i1 + grid[j][i1];
                if (i2 < 0 || i2 >= n || grid[j][i2] != grid[j][i1]) {
                    i1 = -1;
                    break;
                }
                i1 = i2;
            }
            res[i] = i1;
        }
        return res;
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