// 125. Valid Palindrome
// Time: O(N); Space: O(1)

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();        
        // 双指针首尾一起移动，跳过空格
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // 当遇到字母或者数字的时候，比较是否相同
            if (left < right) {
                if (s.charAt(left) != s.charAt(right))
                    return false;
                else { // 相同就继续移动
                    left++;
                    right--;
                }
            }
            
        }
        return true;
    }
}