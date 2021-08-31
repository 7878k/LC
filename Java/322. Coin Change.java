// 322. Coin Change
// Time: O(amount*n); n = amount.length; Space: O(amount)
// 设dp[i]为金额为i的时候需要的硬币最小数
// dp[i] = min F(i - C(j)) + 1, 意思就是算了所有金额到i的最后一步，然后+1

class Solution {
    public int coinChange(int[] coins, int amount) {
		// 最开始设置每个元素都是max，如果最后有凑不出的情况，肯定会出现max > amount
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        int len = coins.length;
        Arrays.fill(dp, max);
        dp[0] = 0; // 0元的时候凑不出答案
        
        for (int i = 1; i <= amount; i++) {
           for (int j = 0; j < len; j++) {
               if (coins[j] <= i) {
                   dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
               }
           }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}