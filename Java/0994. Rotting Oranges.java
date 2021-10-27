// 994. Rotting Oranges
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        int[][] dirs = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                    depth.put(i * n + j, 0);
                }
            }
        }
		
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int row = code / n;
            int col = code % n;
            
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    int curr = x * n + y;
                    queue.offer(curr);
                    
                    depth.put(curr, depth.get(code) + 1);
                    ans = depth.get(curr);
                }
            }
            
        }
		
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
		
        return ans;
    }
}