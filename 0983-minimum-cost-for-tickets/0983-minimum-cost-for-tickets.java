class Solution {
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[366];
        return recursion(days, 0, costs);
    }
    public int recursion(int[] days, int i, int[] costs) {
        if(i >= days.length)
            return 0;
        
        if(dp[i] != null)
            return dp[i];
        // 1day
        int res1 = costs[0] + recursion(days, i + 1, costs);
        // 1 week
        int res2 = costs[1] + recursion(days, calculate(i,7,days), costs);
        // 1 month
        int res3 = costs[2] + recursion(days, calculate(i,30,days), costs);
        
        return dp[i] = Math.min(Math.min(res1, res2), res3);
    }
    public int calculate(int i, int day, int[] days) {
        int lastDay = days[i] + day;
        int res = 366;
        for(int j=i; j<days.length; j++) {
            if(days[j] >= lastDay) {
                res = j;
                break;
            }
        }
        return res;
    }
}