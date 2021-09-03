// 32. Longest Valid Parentheses
// Time: O(n); Space: O(n)
// stack

class Solution {
	// 定义栈顶元素为最后一个没有被匹配的右括号的下标
    public int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
		// 最开始要放入左括号，为了保持最后一个没有被匹配的右括号的下标，先push 1
        stack.push(-1);
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
			// (放入栈中
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
				// 先弹出，表示匹配到了对应的左括号
                stack.pop();
                if (stack.isEmpty()) {
					// 如果是空的，说明当前)没有匹配的(，放入栈中
                    stack.push(i);
                } else {
					// 如果不为空，坐标相减就是当前的右括号的最长有效括号长度
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}