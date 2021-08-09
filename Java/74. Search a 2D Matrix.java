// 74. Search a 2D Matrix
// Time: O(logmn); Space:O(1)
// view the 2d array as a 1d array
// define n is level order, (mid / n, mid % n)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (num == target) {
                return true;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}