// 70. Climbing Stairs
// Time: O(n), Space: O(1)
// 状态转移方程 f(n) = f(n - 1) + f(n - 2)
// 边界 f(1)= 1, f(2) = 2

// space optimize 
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // 走到第一个台阶有一种方法：走一步
        int first = 1;
		// 走到第二个台阶有两种方法：走两步
        int second = 2;
        // 走到第n个台阶 = dp[n - 1] + dp[n - 2]
        for (int i = 3; i <= n; i++) {
			// 从第三个台阶走起，那么肯定是到达前两个台阶的方法之和
			// 滚动数组
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
}


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


class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
        
}

