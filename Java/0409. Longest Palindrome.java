// 409. Longest Palindrome
// Time: O(n), Space: O(s.length())
// 只有出现次数偶数的char和最多1个奇数char才能回文
// 首先看每个char出现几次，然后看奇数一共出现几次，用长度减掉奇数+1就是最后答案

class Solution {
    public int longestPalindrome(String s) {
		// 26大写字母 + 26小写字母 + 6特殊字符
        int[] arr = new int[58];
        int length = s.length();
        // 先看每个字符出现了多少次
        for (char ch : s.toCharArray()) {
            arr[ch - 'A']++;
        }
		
		// 一个回文字符有2钟情况
		// 1, 每个字符出现偶数
		// 2, 每个字符出现偶数，除了一个出现奇数的
        int count = 0;	// 算出现几次奇数的
        for (int num : arr) {
            count += (num % 2);
        }
        
		// 1. 要么都是偶数
		// 2. 全是偶数 + 一个奇数
        return count == 0 ? length : length - count + 1;
    }
}