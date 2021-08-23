// 59. Spiral Matrix II
// Time: O(n^2); Space: O(1)

class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] ans = new int[n][n];
        int num = 1;
        int end = n * n;
        
        while (num <= end) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;	// left -> right
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;	// top -> bottom
            }
            right--;
            
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num++;	// right -> left
            }
            bottom--;
            
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num++;	// bottom -> top
            }
            left++;
        }
        return ans;
    }
}