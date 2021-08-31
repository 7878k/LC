// 27. Remove Element
// Time: O(n), Space: O(1)
// 双指针如果left当前值为val，那么和right替换
// right往左移，只有当当前值不是val的是left才移动

class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}