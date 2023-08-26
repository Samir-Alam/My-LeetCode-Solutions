class Solution {
    private int longestPairChain(int i, int[][] pairs, int n, int[] memo) {
        if (memo[i] != 0)
            return memo[i];
        memo[i] = 1;
        for (int j = i + 1; j < n; j++)
            if (pairs[i][1] < pairs[j][0])
                memo[i] = Math.max(memo[i], 1 + longestPairChain(j, pairs, n, memo));
        return memo[i];
    }
    public int findLongestChain(int[][] pairs) {
        // int n = pairs.length;
        // Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        // int[] memo = new int[n];
        // int ans = 0;
        // for (int i = 0; i < n; i++)
        //     ans = Math.max(ans, longestPairChain(i, pairs, n, memo));
        // return ans;
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curr = Integer.MIN_VALUE;
        int ans = 0;

        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                ans++;
                curr = pair[1];
            }
        }
        return ans;
    }
}