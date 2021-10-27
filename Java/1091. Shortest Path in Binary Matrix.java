// 1091. Shortest Path in Binary Matrix
// Time & Space: O(N)

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
		// base case 如果起点终点都是1，说明访问不了
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
		
        // 遍历八个方向
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        int ans = 0;
        
		// bfs 模板
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
				// 获取当前坐标后，先判断是不是找到答案
                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return ans;
                }
                
                for (int[] dir : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
}