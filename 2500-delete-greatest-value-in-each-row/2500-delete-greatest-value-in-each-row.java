class Solution {
    public int deleteGreatestValue(int[][] grid) {
        // int row = ;
        // int col = ;
        int ans = 0;
        for(int i[] : grid)
            Arrays.sort(i);
        for(int i = 0; i < grid[0].length; i++){
            int max = grid[0][i];
            for(int j = 0; j < grid.length; j++){
                max = Math.max(max, grid[j][i]);        
            }
            ans += max;
        }
        return ans;
    }
}