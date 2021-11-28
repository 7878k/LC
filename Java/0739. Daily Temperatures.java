// 739. Daily Temperatures
// Time&Space: O(n)
// monostack

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
		// 储存下标，说明改下标还未找到下一个温度更高的下标
		// 单调递减
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i]; // 比当前坐标之前高的温度
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}