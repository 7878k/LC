// 409. Longest Palindrome
// Time: O(n), Space: O(s.length())
// 只有出现次数偶数的char和最多1个奇数char才能回文
// 首先看每个char出现几次，然后看奇数一共出现几次，用长度减掉奇数+1就是最后答案

/*
Given a string s which consists of lowercase or uppercase letters, 
return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*/
class Solution {
    public int longestPalindrome(String s) {
        // ASCII码十进制有128个
        int[] arr = new int[128];
        
        for (char c: s.toCharArray())
            arr[c]++;
        
        int count = 0;  // 奇数char出现次数
        for (int i : arr)
            count += (i % 2);
        
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}