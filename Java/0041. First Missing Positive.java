// 41. First Missing Positive
// Time: O(N); Space: O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
		// 先把所有数放到该放的位置
		// 比如num[0] = 1, num[1] = 2 
		// num[num[i] - 1] = num[i]
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
		// 如果有一个数不符合的话，他肯定是missing positive
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
		// 不然的话就是最后一个数
        return len + 1;
    }
}