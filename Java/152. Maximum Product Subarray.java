// 152. Maximum Product Subarray
// Time: O(n); Space: O(n)
// 两种情况，要么当前是负数，那么就希望之前的也是负数，并且越小越好。
// 如果当前是正数，那么之前的越大越好。
// 比来比去，也是跟最大值，最小值，和当前值nums[i]比。
// 需要2个滚动数组来存最大值和最小值

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        System.arraycopy(nums, 0, max, 0, len);
        System.arraycopy(nums, 0, min, 0, len);
        
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(max[i - 1] * nums[i], nums[i]));
        }
        
        return Arrays.stream(max).max().getAsInt();
    }
}


// Time: O(n); Space: O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
		// 从array的第一个值取，所以后面的for loop的i是从1开始
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        
        for (int i = 1; i < len; i++) {
            int tempMax = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(min * nums[i], Math.min(tempMax * nums[i], nums[i]));
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
}