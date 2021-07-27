// 1021. Remove Outermost Parentheses
// Time: O(N), Space:O(1)

/**
 *
 * // 示例一
当前的计数值: 0 1 0 1
            ( ) ( )
遍历后计数值: 1 0 1 0

// 示例二
当前的计数值: 0 1 2 1 2 1 0 1
            ( ( ) ( ) ) ( ) 
遍历后计数值: 1 2 1 2 1 0 1 0
 
 根据上述两个示例，我们可以很快的找出规律：

遇到左括号，当前计数值大于 00 ，则属于有效的左括号。
遇到右括号，当前计数值大于 11 ，则属于有效的右括号
*/

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && count++ > 0) {
                sb.append('(');
            } 
            
            if (s.charAt(i) == ')' && count-- > 1) {
                sb.append(')');
            }
        }
        return sb.toString();
    }
}