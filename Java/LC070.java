// 70. Climbing Stairs
// Time: O(n), Space: O(1)
class Solution {
    public int climbStairs(int n) {
        // dp[i] = dp[i -1] + dp[i -2]
        int step1 = 0;  // 走一步
        int step2 = 0;  // 走两步
        int result = 1; // 到达第0位置有一种情况，那就是不动
        
        for (int i = 1; i <= n; i++) {
            step1 = step2;
            step2 = result;
            result = step1 + step2;
        }
        return result;
    }
}