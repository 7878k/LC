// 300. Longest Increasing Subsequence
// Time: O(n^2); Space: O(n)
// dp[i] 是前i个元素，以第i个数字结尾的最长上升子序列的长度。

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 定义dp[i]是前i个数中，以第i个数字结尾的最长上升子序列的长度
        int[] dp = new int[len];
        dp[0] = 1;  // 默认都为1，就是它本身
        int ans = 1;
        
        for (int i = 1; i < len; i++) {
            dp[i] = 1;  // 每一轮都最开始都为1
            for (int j = 0; j < i; j++) {  
                // 看i前面的数能否放在i的前面
                if (nums[i] > nums[j]) {
                    // 能的话就取前面的数结尾的最大值 + 1，和当前dp[i]比较
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]); // 答案是总的最大值
        }
        
        return ans;
    }
}