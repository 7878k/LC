// 1277. Count Square Submatrices with All Ones
// Time & Space: O(mn)

class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix == null || rows == 0 || cols == 0) {
            return 0;
        }
        int[][] dp = new int[rows][cols];
        int ans = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j -  1], dp[i - 1][j - 1])) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}