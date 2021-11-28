// 375. Guess Number Higher or Lower II
// Time: O(n^3); Space: O(n^2)
// 一共有n^2个状态，每个状态遍历n次
// SPEND: 30min

class Solution {
	static int[][] dp = new int[201][201];
    public int getMoneyAmount(int n) {
        return dfs(1, n, dp);
    }
    
    private int dfs(int left, int right, int[][] dp) {
        if (left >= right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        
        int ans = 0x3f3f3f3f;
        for (int i = left; i < right; i++) {
            int cur = Math.max(dfs(left, i - 1, dp), dfs(i + 1, right, dp)) + i;
            ans = Math.min(ans, cur);
        }
        
        return dp[left][right]= ans;
    }
}


// Time: O(n^3); Space: O(n^2)
class Solution {
    public int getMoneyAmount(int n) {
		// dp[i][j]表示在[i, j]之间的最小money
		// 因为有Math.max(dp[i][k - 1], dp[k + 1][j])
		// 所以要从后面开始算
        int[][] dp = new int[n + 1][n + 1];
        for (int i =  n - 1; i >= 1; i--) {	// 从后面开始算，才能算出前面的dp
            for (int j = i + 1; j <= n; j++) {	// 右边界
                int ans = 0x3f3f3f3f;
                for (int k = i; k < j; k++) { // 左边界 （i < j，其他条件无效)
                    int cost = Math.max(dp[i][k - 1], dp[k + 1][j]) + k;
                    ans = Math.min(cost, ans);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n];
    }
}