// 318. Maximum Product of Word Lengths
// Time: O(L + n^2); Space: O(n)
// Spend: 30min

class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                // use bitmask to map every char in the word to the array
                mask[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}