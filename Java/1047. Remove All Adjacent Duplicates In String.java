// 1047. Remove All Adjacent Duplicates In String
// Time & Space: O(n)

class Solution {
    public String removeDuplicates(String s) {
        // using StringBuilder to mock a stack
        StringBuilder stack = new StringBuilder();
        int top = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // if stack contains elements (top >= 0) and current char == top element
            if (top >= 0 && ch == stack.charAt(top)) {
                stack.deleteCharAt(top);
                top--;
            } else {
                // if not, append current char and top + 1
                stack.append(ch);
                top++;
            }
        }
        return stack.toString();
    }
}