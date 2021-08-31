// 139. Word Break
// Time: O(n); Space: O(1)

/**
*
首先设置dp[i]为(0, i -1)个字符能否被拆封成若干个单词。
然后设置j为word break，如果dp[j]能被拆分，并且(j, i)存在与字典里，那么这个string
就可以被分割。
**/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}

// 剪枝
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int maxLength = 0;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        HashSet<String> dict = new HashSet<>();
        
		// 计算最长的word，然后找到break j后的string必须要小于等于这个word
        for (String word : wordDict) {
            dict.add(word);
            maxLength = Math.max(word.length(), maxLength);
        }
        
        for (int i = 1; i <= len; i++) {
			//
            for (int j = i - 1; j >= 0 && i - j <= maxLength; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}