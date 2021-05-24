// 125. Valid Palindrome
// Time: O(n), Space: O(1)
// 2个指针在string上移动，如果不是letter or digit就往前走
/**
Given a string s, determine if it is a palindrome,
considering only alphanumeric characters and ignoring cases.
*/
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
			return true;
		}
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            
            if (s.charAt(left++) != s.charAt(right--))
                    return false;
        }
     return true;
    }
}