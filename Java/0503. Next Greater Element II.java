// 503. Next Greater Element II
// Time & Space: O(n)
// 单调栈

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
		// stack中存的是nums中有单调性的下标
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        int newLen = len * 2 - 1; // 拉伸原数组长度，所以就当作是个circle
        
        for (int i = 0; i < newLen; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                ans[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return ans;
    }
}