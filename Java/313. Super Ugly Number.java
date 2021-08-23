// 313. Super Ugly Number
// Time: O(nm); Space: O(n + m)
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minVal = Math.min(minVal, nums[j]);
            }
            dp[i] = minVal;
            for (int k = 0; k < m; k++) {
                if (minVal == nums[k]) {
                    pointers[k]++;
                }
            }
        }
        return dp[n];
    }
}