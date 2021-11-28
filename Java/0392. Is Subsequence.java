// 392. Is Subsequence
// Time & Space: O(mn)
// dp[m][n]为在s的m-1和t的n-1为结尾，相同子序列的长度
// SPEND: 20MIN

class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
				// 找到一个相同字符，相同子序列长度+1
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
					// 说明当前字符不相同，看t删除1个字符是否相同
                } else {
                    dp[i][j] = dp[i][j- 1];
                }
            }
        }
        
        return dp[m][n] == m;
    }
}

// two point
// Time: O(m + n); Space: O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int i = 0;
        int j = 0;
        
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == len1;
    }
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        
        int i = 0, j;
        int len1 = s.length();
        int len2 = t.length();
        for (j = 0; j < len2; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i == len1) {
                return true;
            }
        }
        
        return false;
    }
}