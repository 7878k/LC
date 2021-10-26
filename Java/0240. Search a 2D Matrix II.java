// 240. Search a 2D Matrix II
// Time: O(n + m); Space: O(1)
// spent: 10min

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int x = matrix.length -1;
        int y = 0;
        
        // 从左下角开始找，比target大就向上移动，小就向右移动
        while (x >= 0 && y <matrix[0].length) {
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}