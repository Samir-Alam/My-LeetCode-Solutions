class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
        
        // int n = prices.length;
        // int[] free = new int[n], hold = new int[n];
        // hold[0] = -prices[0];
        // for (int i = 1; i < n; i++) {
        //     hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
        //     free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        // }
        // return free[n - 1];
    }
}