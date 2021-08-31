// 733. Flood Fill
// Time & Space: O(n * m)

class Solution {
    int[][] next = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        backtrack(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void backtrack(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || oldColor == newColor 
            || image[x][y] != oldColor) {
            return;
        }
		
        image[x][y] = newColor;
        for (int[] dir : next) {
            backtrack(image, x + dir[0], y + dir[1], oldColor, newColor);
        }
    }
    
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        helper(image, sr, sc, newColor, image[sr][sc]);

        return image;

    }

    void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {
        
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length 
            || image[sr][sc] != oldColor || newColor == oldColor){
            return;
        }
            
        image[sr][sc] = newColor;

        helper(image, sr - 1, sc, newColor, oldColor);
        helper(image, sr + 1, sc, newColor, oldColor);
        helper(image, sr, sc - 1, newColor, oldColor);
        helper(image, sr, sc + 1, newColor, oldColor); 

    }
} 