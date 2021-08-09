// 300. Longest Increasing Subsequence
// Time: O(n^2); Space: O(n)
// dp[i] 是前i个元素，以第i个数字结尾的最长上升子序列的长度。

class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        
        int[] dp = new int[length];
		// 第一个数只有一个答案，就是它自己
        dp[0] = 1;
        int max = 1;
        
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
				// 如果当前值比nums[i]小，就可以放在后面
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}