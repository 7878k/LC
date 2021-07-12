// 67. Add Binary
// Given two binary strings a and b, return their sum as a binary string.
// 和415一样， 只不过变成二进制，就把算位数和进位数的10变成2
// Time: O(max(n1, n2))
// Space: O(max(n1, n2))
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        
        int carry = 0;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        
        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int x1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            int add = x1 + x2 + carry;
            
            int value = add % 2; // 二进制就是除以2
            carry = add / 2;
            res.append(value);
            
            p1--;
            p2--;
        }
        return res.reverse().toString();
    }
}