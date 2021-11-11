// 299. Bulls and Cows
// Time: O(n); Space: O(1)
// SPEND: 20min

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secrets = new int[10];
        int[] guesses = new int[10];
        int len = secret.length();
        
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secrets[secret.charAt(i) - '0']++;
                guesses[guess.charAt(i) - '0']++;
            }
        }
        
        for (int i = 0; i < 10; i++) {
			// only choose the less one
			// ince the non-bull digits can only be rearranged to allow one digit to be a bull
            cows += Math.min(secrets[i], guesses[i]);
        }
        
        StringBuilder ans = new StringBuilder();
        ans.append(bulls).append("A").append(cows).append("B");
        
        return ans.toString();
    }
}