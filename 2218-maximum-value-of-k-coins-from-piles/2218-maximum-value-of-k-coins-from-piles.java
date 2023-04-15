class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        for (int i = 1; i <= piles.size(); i++){
            for (int j = 1; j <= k; j++){
                int sum = 0;
                dp[i][j] = dp[i - 1][j];
                for (int h = 0; h < Math.min(j, piles.get(i-1).size()); h++){
                    sum += piles.get(i - 1).get(h);
                    dp[i][j] = Math.max(dp[i][j], sum + dp[i - 1][j - 1 - h]);
                }
            }
        }
        return dp[piles.size()][k];
    }
}