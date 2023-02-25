class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], max = 0;
        for(int i = 0; i < prices.length; i++){
            buy = Math.min(buy, prices[i]);
            int profit = prices[i] - buy;
            max = Math.max(profit, max);
        }
        return max;
    }
}