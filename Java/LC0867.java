// 867. Transpose Matrix
// Given a 2D integer array matrix, return the transpose of matrix.
// 长度为m,n的array变成n，m的array，并且横纵坐标桥换位置
// time: O(mn), space: O(1)
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}