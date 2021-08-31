// 892. Surface Area of 3D Shapes
// Time: O(n^2); Space: O(1)
// 整体思路： 先看有多少个立方体，算总的体积，然后减去重叠的体积

class Solution {
    public int surfaceArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;
        int verticalOverlap = 0;
        int rowOverlap = 0;
        int colOverlap = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j];
                
				// 只要是当前单元格的值严格大于 1，就有重叠的部分，重叠的部分是当前单元格的值
                if (grid[i][j] > 1) {
                    verticalOverlap += grid[i][j] - 1;
                }
                
				// 重叠的部分是相邻两个单元格在行的视角的值的最小值
                if (j > 0) {
                    rowOverlap += Math.min(grid[i][j - 1], grid[i][j]);
                }
                
				// 重叠的部分是相邻两个单元格在列的视角的值的最小值
                if (i > 0) {
                    colOverlap += Math.min(grid[i - 1][j], grid[i][j]);
                }
            }
        }
        return sum * 6 - (verticalOverlap + rowOverlap + colOverlap) * 2;
    }
}