// 14. Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
// Time: O(S), S is the sum of all charactes in all strings
// Space: O (1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) // corner case
            return "";
        
        String result = strs[0]; // 横向扫描从第一个string扫起
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) { // 如果最开始就不相同，删除最后一个char
                result = result.substring(0, result.length() - 1);
                if (result.length() == 0) // 如果最后result没有了，就return empty
                    return "";
            }
        }
        return result;
    }
}