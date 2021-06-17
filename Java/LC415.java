// 415. Add Strings
// Given two non-negative integers, num1 and num2 represented as string, 
// return the sum of num1 and num2 as a string.
// Time: O(max(N1, N2))
// Space: O(max(N1, N2))
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        int carry = 0; // 进位数
        int p1 = num1.length() - 1; // p1 p2是指向num1和num2末尾的两个数
        int p2 = num2.length() - 1;
        
        // 当p1或者p2超过其num的位数（为负数）的时候，将其变成0
        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            // char to int 就减去'0'
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int add = x1 + x2 + carry;
            
            int value = add % 10; // 当前位数的结果
            carry = add / 10;     // 进位数
            result.append(value);
            p1--;
            p2--;
        }
        
        return result.reverse().toString(); // 最后反转一哈
    }
}