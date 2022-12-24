class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(int i[] : grid)
            Arrays.sort(i);
        for(int i = 0; i < col; i++){
            int max = grid[0][i];
            for(int j = 0; j < row; j++){
                max = Math.max(max, grid[j][i]);        
            }
            ans += max;
        }
        return ans;
    }
}