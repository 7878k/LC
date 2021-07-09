// 9. Palindrome Number
//Time: O(n), Space: O(N)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        return x == reverse(x);
    }
    
    // reverse and compare
    private int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}