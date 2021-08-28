// 198. House Robber
// Time: O(n); Space: O(1)
// 因为不能连续偷，所以间隔偷有两种情况：偷当前的第i个，但是不偷前一个；偷前一个，不偷第i个
// 得到转移方程dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
		// 如果只有一间房屋，则偷窃该房屋，可以偷窃到最高总金额。
		// 如果只有两间房屋，则由于两间房屋相邻，不能同时偷窃，只能偷窃其中的一间房屋，
		// 因此选择其中金额较高的房屋进行偷窃，可以偷窃到最高总金额
        // 可以用滚动数组储存前两间房最高总金额
        int first = nums[0];
		// second永远是储存最大值
        int second = Math.max(first, nums[1]);
        
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }
        
        return second;
    }
}