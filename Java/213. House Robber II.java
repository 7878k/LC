// 213. House Robber II
// Time: O(n); Space: O(1)

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
			// 如果有至少三个元素，选了第一个元素，就不能选最后一个， 范围就是[0, length - 2]
			// 如果选最后一个元素，就不能选第一个，范围就是[1, length - 1]
        } else {
            return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
        }
    }
    
    private int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(first, nums[start + 1]);
        
		// 从第三个元素开始，所以是从start + 2开始
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }
        
        return second;
    }
}