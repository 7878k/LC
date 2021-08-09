// 35. Search Insert Position
// Time: O(log(n)), Space: O(1)
// reurn left 

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return left;
    }
}

// 这种方法不用判断return left/right	
class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}