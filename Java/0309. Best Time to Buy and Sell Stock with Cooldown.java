// 309. Best Time to Buy and Sell Stock with Cooldown
// Time: O(n); Space: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;
        
		// dp[0]先算了，后面还要用，可能会覆盖，所以搞个变量储存下
        int pre0 = dp[0];
        
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[2]);
            dp[1] = Math.max(dp[1], pre0 - prices[i]);
            dp[2] = dp[1] + prices[i];
            
            pre0 = dp[0];
        }
        
        return Math.max(dp[0], dp[2]);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        
        int[][] dp = new int[len][3];
		// 不持股且当天没卖股票
        dp[0][0] = 0;
		// 持股
        dp[0][1] = -prices[0];
		// 不持股且卖了股票
        dp[0][2] = 0;
        
        for (int i = 1; i < len; i++) {
			//                                昨天卖了股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
			// 								  今天买了股票，因为有冷冻期，所以昨天肯定没卖
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			// 卖了股票，那么昨天肯定有股票
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}

// Time: O(n); Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size <= 1){
            return 0;
        }
        
        int dp_0 = -prices[0];
        int dp_1 = 0;
        int dp_2 = 0;
        for (int i = 1; i < size; i++){
            dp_0 = Math.max(dp_0, dp_1 - prices[i]);
            dp_1 = Math.max(dp_1, dp_2);
            dp_2 = dp_0 + prices[i];
        }
        return Math.max(dp_1, dp_2);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        
        int[] dp = new int[3];
        dp[0] = 0;  
        dp[1] = -prices[0];
        dp[2] = 0;
        
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[2]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = dp[1] + prices[i];
        }
        
        return Math.max(dp[0], dp[2]);
    }
}