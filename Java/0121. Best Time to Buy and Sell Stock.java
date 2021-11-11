// 121. Best Time to Buy and Sell Stock
// Time: O(n), Space: O(1)
// SPEND: 10min

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        
		// dp[i]表示现在手上多少钱
        int[] dp = new int[2];
		// 0表示手里没有股票，那就没钱
        dp[0] = 0;
		// 1表示手里有股票，那么手上的钱就是负数
        dp[1] = -prices[0];
        
        for (int i = 1; i < len; i++) {
			// 如果没股票，那么前一天和今天都没买；如果昨天买了股票，今天就卖了
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
			// 如果有股票，昨天也有，那就是昨天的钱；如果昨天没有今天有，那么手里的钱是负数
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        // 最后股票卖了，状态肯定是0
        return dp[0];
    }
}

class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
			// 1, 昨天不持股今天什么都不做; 2, 昨天持股今天卖了（现金数增加）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			// 1, 昨天持股今天什么都不做（现金数不变）; 2, 昨天不持股今天买入
			// 因为只能交易一次，所以之前肯定没买股票，身上没有一分钱，所以dp[i][1]肯定是负数
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}

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