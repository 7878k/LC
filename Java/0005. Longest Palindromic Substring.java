// 5. Longest Palindromic Substring
// Time: O(n^2); Space: O(1)
// 中心扩散， 回文只有两种情况，
// 1: a; 2: aa
// 从左到右遍历所有情况，因为s[i, j]的长度是要从某个边界情况扩散得到，
// 算完所有的，不能扩散了，就是最终情况。

class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
		// base case
        if (length == 0 || s == null) {
            return "";
        }
		
        // 初始化最大回文子串的起点和终点
        int start = 0;
        int end = 0;
        
		// 遍历每个位置，当做中心位
        for (int i = 0; i < length; i++) {
			// 分别拿到奇数偶数的回文子串长度
            int len1 = centerSpread(s, i, i);
            int len2 = centerSpread(s, i, i + 1);
			// 对比最大的长度
            int len = Math.max(len1, len2);
            
			// 计算对应最大回文子串的起点和终点
            if (len > end - start) {
				// 用 (len - 1) / 2 考虑到len奇数偶数的情况
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
		// 注意：这里的end+1是因为 java自带的左闭右开的原因
        return s.substring(start, end + 1);
    }
    
    private int centerSpread(String s, int left, int right) {
		// left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
		// 回文串的长度是right-left+1-2 = right - left - 1
        return right - left - 1;
    }
}