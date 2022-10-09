class Solution {
    public int numberOfPaths(int[][] grid, int K) {
        int[][][] dp = new int[grid.length][grid[0].length][K];
        int mod = 1000000007;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j][grid[i][j] % K] = 1;
                    continue;
                }
                for (int k = 0; k < K; k++) {
                    if (i > 0) {
                        dp[i][j][(k + grid[i][j]) % K] += dp[i - 1][j][k];
                        dp[i][j][(k + grid[i][j]) % K] %= mod;
                    }
                    if (j > 0) {
                        dp[i][j][(k + grid[i][j]) % K] += dp[i][j - 1][k];
                        dp[i][j][(k + grid[i][j]) % K] %= mod;
                    }
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1][0];
    }
}