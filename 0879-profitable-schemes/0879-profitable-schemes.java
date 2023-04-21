class Solution {
    int mod = 1000000007;
    int[][][] memo = new int[101][101][101];
    
    int find(int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
        if (pos == group.length) {
            // If profit exceeds the minimum required; it's a profitable scheme.
            return profit >= minProfit ? 1 : 0;
        }
        
        if (memo[pos][count][profit] != -1) {
            // Repeated subproblem, return the stored answer.
            return memo[pos][count][profit];
        }
        
        // Ways to get a profitable scheme without this crime.
        int totalWays = find(pos + 1, count, profit, n, minProfit, group, profits);
        if (count + group[pos] <= n) {
            // Adding ways to get profitable schemes, including this crime.
            totalWays += find(pos + 1, count + group[pos], Math.min(minProfit, profit + profits[pos]), n, minProfit, group, profits);
        }
        
        return memo[pos][count][profit] = totalWays % mod;
    }
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // Initializing all states as -1.
        for (int i = 0; i <= group.length; i++) {
            for(int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        return find(0, 0, 0, n, minProfit, group, profit);
    }
}