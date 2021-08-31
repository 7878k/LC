// 1190. Reverse Substrings Between Each Pair of Parentheses
// Time: O(N^2); Space: O(n)
// 先反转里面的括号，再反转外面的括号，反转里面的括号后，把括号之前的char加到sb里面

class Solution {
    public String reverseParentheses(String s) {
		// stack是存当前括号的所有字符
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
			// 左括号就将当前层的str(这个str其实是前一层的）放入stack，然后把sb重置
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
			// 右括号就先反转str，然后放回上一层，把之前层的放到这个sb的前面
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
			// 如果是字母就直接加到当前层的sb后面
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

