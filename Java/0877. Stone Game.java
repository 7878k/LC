// 877. Stone Game
// Time&Space: O(N^2)
// dp[i][j] 表示双方都做最好决策，先手后手得分的分差
class Solution {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];

        for (int i = 2; i <= len; i++) { // 枚举区间长度,因为是even至少2个
            for (int left = 0; left + len - 1 < len; left++) {
                int right = left + len - 1;
				// 左端先手后，之后的后手变成先手，选取范围
				// 变成从[left + 1, right]，此时双方的差值为a
                int a = piles[left] - dp[left + 1][right];
                int b = piles[right] - dp[left][right - 1];
                dp[left][right] = Math.max(a, b);
            }
        }
		// 若差值大于0，说明先手的分更高
        return dp[0][len - 1] > 0;
    }
}