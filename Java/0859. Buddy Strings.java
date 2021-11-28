// 859. Buddy Strings
// Time: O(n); Space: O(c)
// Spend: 20min

class Solution {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) {
            return false;
        }
        
        int[] countS = new int[26];
        int[] countGoal = new int[26];
        int diff = 0;
        
        for (int i = 0; i < m; i++) {
            int indexS = s.charAt(i) - 'a';
            int indexG = goal.charAt(i) - 'a';
            countS[indexS]++;
            countGoal[indexG]++;
            if (indexS != indexG) {
                diff++;
            }
        }
        
        boolean exchangeable = false;
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countGoal[i]) {
                return false;
            }
            if (countS[i] > 1) {
                exchangeable = true;
            }
        }
        
        return diff == 2 || (diff == 0 && exchangeable);
    }
}