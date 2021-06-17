// 121. Best Time to Buy and Sell Stock
// Time: O(n), Space: O(1)
// 首先找到当前的历史最低价格，然后看这后面卖出的利润哪天更高
// dp[i] 表示截止到第i天，最低价是多少 dp[i] = min(dp[i-1], prices[i])

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}