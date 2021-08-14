// 58. Length of Last Word
// Time: O(N); Space: O(1)
// 两种情况：1，最后一个是空格，那就把它删了，2，最后不是空格，那就找下一个空格，计算之间的长度

class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        if (end < 0) {
            return 0;
        }
        
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        
        return end - start;
    }
}