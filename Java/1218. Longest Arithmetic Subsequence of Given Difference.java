// 1218. Longest Arithmetic Subsequence of Given Difference
// Time: O(n); Space: O(n)
// spend: 15min
// dp[i] = dp[j] + 1; dp[j] = dp[num - difference]
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
            ans = Math.max(ans, map.get(num));
        }
        return ans;
    }
}