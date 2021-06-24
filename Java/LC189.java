// 189. Rotate Array
// Given an array, rotate the array to the right by k steps, where k is non-negative.
// Time: O(N), Space: O(1)
// 把数组往后移k就相当于先反转，reverse前k个，然后reverse后k个
// nums = "----->-->"; k =3
// result = "-->----->";
// reverse "----->-->" we can get "<--<-----"
// reverse "<--" we can get "--><-----"
// reverse "<-----" we can get "-->----->"

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}