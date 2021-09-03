// 131. Palindrome Partitioning
// Time: O(n*2^n); Space: O(n)

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            centerSpread(s, i, i, len, dp);
            centerSpread(s, i, i + 1, len, dp);
        }
        backtrack(s, ans, new ArrayList<>(), 0, dp, len);
        return ans;
    }
    
    private void centerSpread(String s, int left, int right, int len, boolean[][] dp) {
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            dp[left][right] = true;
            left--;
            right++;
        }
    }
    
    private void backtrack(String s, List<List<String>> ans, List<String> path,
                           int index, boolean[][] dp, int len) {
        if (index == len) {
            ans.add(new ArrayList<>(path));
        }
        
        for (int i = index; i < len; i++) {
            if (!dp[index][i]) {
                continue;
            }
            
            path.add(s.substring(index, i + 1));
            backtrack(s, ans, path, i + 1, dp, len);
            path.remove(path.size() - 1);
        }
    }
}