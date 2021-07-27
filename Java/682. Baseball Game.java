// 682. Baseball Game
// Time & SpaceL O(n)

class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                int num1 = stack.pop();
                int num2 = num1 + stack.peek();
                stack.push(num1);
                stack.push(num2);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        
        int ans = 0;
        for (Integer num : stack) {
            ans += num;
        }
        
        return ans;
    }
}