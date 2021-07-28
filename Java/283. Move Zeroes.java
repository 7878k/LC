// 283. Move Zeroes
// time: O(n), space: O(1)
// 两个挡板， left左边是已处理的，不包括left， right右边都是需要处理的，包括right
// right如果不为0，就和left换位置，然后left++，
// 每一轮right++，因为right需要遍历整个nums，移动了就判断当前数是不是0
class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length -1;
        int left = 0;
        int right = 0;
        
        while (right <= length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
    }
}


// 单指针
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        while (index < length)
            nums[index++] = 0;
    }
}