// 154. Find Minimum in Rotated Sorted Array II
// Time: O(logn); Space:O(1)

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--; // 如果nums[mid] == nums[right], 可能有重复元素，去掉right，还有个nums[mid]和它相等
            }
        }
        return nums[left];
    }
}