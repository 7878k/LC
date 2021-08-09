// 153. Find Minimum in Rotated Sorted Array
// Time: O(logn); Space:O(1)
// 旋转数组里找pivot中点，如果中点和最右数比较，更小，说明右边都不用看了，right = pivot
// 如果比最右数大，说明pivot左边的都不是最小值
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
		
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}