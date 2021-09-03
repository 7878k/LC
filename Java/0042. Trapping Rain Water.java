// 42. Trapping Rain Water
// Time: O(n); Space: O(1)
// tip: 当前积水量，只跟较小的一边有关
// 比较left right的值，哪边小就用哪边的max - height[cur]
// 然后移动对应指针

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        
		// 当left == right的时候，是接不到雨水的
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
			// 如果左高度<右高度，那么左max<右max
			// 高度是由最小值决定的，所以用左边算高度
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
			// 同理
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}