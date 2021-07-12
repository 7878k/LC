// 53. Maximum Subarray
// Time: O(n), Space: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int length = nums.length;
        int cur = nums[0];
        
        // dp[i] means the largest sum of subarray ending at index i.
        // dp[i] = nums[i] if nums[i-1] < 0
        // dp[i] = nums[i-1] + nums[i]  if nums[i-1] > 0
        for (int i = 1; i < length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            result = Math.max(cur, result);
        }
        return result;
    }
}