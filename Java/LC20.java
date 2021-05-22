// 20. Valid Parentheses
// Time: O(n), Space: O(n)

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1.Open brackets must be closed by the same type of brackets.
2.Open brackets must be closed in the correct order.
*/
class Solution {
    public boolean isValid(String s) {
        // 如果长度不是偶数，肯定不符合。
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        // 把右括号放到map当key查value，因为stack是lifo，所以最后的括号肯定跟最前的括号对应。
        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        
        // 把左括号放到stack里，如果map里没有这个，就放进stack
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 如果map里有这个，看stack有没有对应的，或者stack是不是空的（只有其中一个括号）
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                // 有就把对应的左括号对应掉
                stack.pop();
            } else {    // 没有就放一个左括号进stack
                stack.push(ch);
            }
        }
        // 最后如果stack是空的，说明所有左括号都有个对应的右括号
        return stack.isEmpty();
    }
}

