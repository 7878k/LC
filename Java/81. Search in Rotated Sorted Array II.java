// 81. Search in Rotated Sorted Array II
// Time: O(n), Space:O(1)
class Solution {
	// 中间的数与右边界比较
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[right]) {
				// 具体例子：[10, 11, 4, 5, 6, 7, 8, 9]，mid 右边的一定是顺序数组，包括 nums[mid]
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
				// 具体例子：[4, 5, 9, 2]，mid 左边是一定是顺序数组，包括 nums[mid]
				// 切记这里要改成 mid - 1，和上一个if对应！
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] == target) {
                    return true;
                }
				// 如果nums[right/mid] != target, 这个位置可以直接排除
                right--;
            }
        }
        return nums[left] == target; // 最后还有一个数，记得比较下~
    }
}