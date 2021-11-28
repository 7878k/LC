// 72. Edit Distance
// Time: O(mn); Space: O(1)
// SPEND: 30min
// https://leetcode-cn.com/problems/edit-distance/solution/san-chong-shi-xian-xiang-xi-tu-jie-72-bi-y0mb/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[] dp = new int[n + 1]; // 只用word2做dp
        for (int i = 0; i <= n; i++) {
            // 当m都是0时
            dp[i] = i;
        }
        
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0];	// 每轮的遍历开始，pre取第一列的值；第一轮dp[0]就是第一个数0
            dp[0] = i; // 每轮第一列的值，相当于二维数组中对应的第一列值
            for (int j = 1; j <= n; j++) {
                // a, b, c对应三种方法
				// 这时i是上一轮，也就是i - 1
				// j也是上一轮，j - 1
                int a = dp[j] + 1;	//插入word1（此时i为i-1) 为上一轮的i-1
                int b = dp[j - 1] + 1; // 插入word2，此时这一轮为i
                int c = leftUp + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                leftUp = dp[j];	// 左上的值在内层循环下一轮遍历前赋值为当前dp[j]
								// 左上的值下一轮右移1个，变成当前的dp[j]
                dp[j] = Math.min(a, Math.min(b, c));
            }
        }
        
        return dp[n];
    }
}

// Time&Space: O(mn)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
		//判断其中一个是空
        if (m * n == 0) {
            return m + n;
        }
        
		// dp[i][j]表示以i-1和j-1结尾的word1到word2需要编辑多少次
        int[][] dp = new int[m + 1][n + 1];
		// 边界情况
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
				// word1插入一个char
                int a = dp[i - 1][j] + 1;
				// word2插入一个char
                int b = dp[i][j - 1] + 1;
				// 修改word1的一个字符，如果该字符和word2的相同，则不用+1
                int c = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }
        return dp[m][n];
    }
}