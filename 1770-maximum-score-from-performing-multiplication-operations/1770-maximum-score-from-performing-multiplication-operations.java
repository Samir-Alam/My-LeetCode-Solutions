class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int N = nums.length, M = multipliers.length;
        return helper(nums, multipliers, 0, N - 1, new Integer[M][M]);
    }
    private int helper(int[] nums, int[] multipliers, int i, int j, Integer[][] dp) {
        int N = nums.length, M = multipliers.length;
        int index = (i - 0) + (N - 1 - j);
        if (index == M) return 0;
        if (dp[i][j - (N - M)] != null) return dp[i][j - (N - M)];
        int res = Math.max(nums[i] * multipliers[index] + helper(nums, multipliers, i + 1, j, dp), 
                           nums[j] * multipliers[index] + helper(nums, multipliers, i, j - 1, dp));

        return dp[i][j - (N - M)] = res;
    }
}