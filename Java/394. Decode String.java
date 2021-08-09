// 394. Decode String
// Time: O(N); Space: O(N)

class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c); // 把所有的字母push进去，除了]
            } else {
				//step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder(); // 当前层的字符串
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                
                String subArray = sb.toString(); //[ ]内的字符串
                stack.pop(); 	// 去掉[
                
                sb.setLength(0); // 清空sb
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
				// 获得数字
                int count = Integer.valueOf(sb.toString());
                
                while (count > 0) {
                    for (char ch : subArray.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        
        return ans.toString();
    }
}