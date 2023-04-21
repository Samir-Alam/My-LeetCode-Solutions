class Solution {
    int MOD = 1_000_000_000 + 7;

    int[] group, profit;
    int minProfit, totalCrimes;

    Integer[][][] cache;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
      this.group = group; this.profit = profit;
      this.minProfit = minProfit; this.totalCrimes = profit.length;

      // Create cache and solve recursively.
      this.cache = new Integer[n + 1][minProfit + 1][totalCrimes];
      return countProfitableSchemes(n, 0, 0);
    }

    int countProfitableSchemes(int members, int currProfit, int crime) {
      // base case: no more members to commit crimes, or no more crimes.
      if (members == 0 || crime == totalCrimes)
        return currProfit == minProfit ? 1 : 0;
      
      // base case: already solved this problem.
      if (cache[members][currProfit][crime] != null)
        return cache[members][currProfit][crime];
      
      // try skipping the current crime.
      long count = countProfitableSchemes(members, currProfit, crime + 1);

      // try committing current crime if we have enough members.
      if (members >= group[crime]) {
        // next profit cannot exceed the min profit needed.
        int newProfit = Math.min(minProfit, currProfit + profit[crime]);
        count += countProfitableSchemes(members - group[crime], newProfit, crime + 1);
      }

      // cache result for later.
      return cache[members][currProfit][crime] = (int) (count % MOD);
    }
}