// 518. Coin Change 2
// Time: O(amount * n); Space: O(amount)
// 定义dp[i]为amount为i时有多少种组合

class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1; // amount为0时有1种组合
        
		// coin在外层不会重复
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
				// check存在一种组合金额之和是i - coin
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}