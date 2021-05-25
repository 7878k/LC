// 674. Longest Continuous Increasing Subsequence
// Time: O(n), Space: O(1)
// dp[i] = 1 (array[i] <= array[i-1])
//       = dp[i-1] + 1 (array[i-1] < array[i])

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        int result = 1;
        int cur = 1;
        
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] < nums[i]) {
                cur++;
                result = Math.max(cur, result);
            } else {
                cur = 1;
            }
        }
        return result;
    }
}