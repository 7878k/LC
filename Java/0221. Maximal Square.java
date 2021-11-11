// Time & Space: O(mn)
// spend: 10min
// dp[i][j] 表示以(i,j)为右下角的只包含1的边长最大值
// 最大值由该角的左上左上角的最小值决定

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide = 0;
        if (matrix == null || m == 0 || n == 0) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
						// 找到相邻的最小值+1，1是自己的大小
                        dp[i][j] = Math.min(dp[i - 1][j] , Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}