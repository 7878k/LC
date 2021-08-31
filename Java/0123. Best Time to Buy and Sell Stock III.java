// 123. Best Time to Buy and Sell Stock III
// Time: O(n); Space: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0; // sell1同一天买入卖出，就是0
        int buy2 = -prices[0], sell2 = 0; // buy2 同一天买入卖出再买入
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}