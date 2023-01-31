class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        final int n = ages.length;
        int[][] ageScorePair = new int[n][2];
        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }
        Arrays.sort(ageScorePair, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        Integer[][] dp = new Integer[n][n];
        return findMaxScore(dp, ageScorePair, -1, 0);
    }
    private int findMaxScore(Integer[][] dp, int[][] ageScorePair, int prev, int index) {
        if (index >= ageScorePair.length)
            return 0;
        if (dp[prev + 1][index] != null)
            return dp[prev + 1][index];
        if (prev == -1 || ageScorePair[index][1] >= ageScorePair[prev][1])
            return dp[prev + 1][index] = Math.max(findMaxScore(dp, ageScorePair, prev, index + 1),
                    ageScorePair[index][1] + findMaxScore(dp, ageScorePair, index, index + 1));
        return dp[prev + 1][index] = findMaxScore(dp, ageScorePair, prev, index + 1);
    }

}