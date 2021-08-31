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

// 子问题 dp[i]: 表示以 nums[i] 结尾 的 连续 子数组的最大和。
// 状态转移方程： 如果dp[i - 1] < 0 那么dp[i] = nums[i];
// otherwise: dp[i] = nums[i] + dp[i - 1]
// 反正都和nums[i]有关 dp[i] = Math.max(nums[i], dp[i - 1] + nums[i])

// Space optimize  
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            ans = Math.max(pre, ans);
        }
        
        return ans;
    }
}


// naive solution 
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = nums[0];
        
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}