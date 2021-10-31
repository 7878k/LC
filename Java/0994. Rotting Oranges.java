// 994. Rotting Oranges
// Time & Space: O(mn)

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1} };
        int count = 0;
        int ans = 0;
        
		// 先遍历好橘子烂橘子数量
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
		// bfs
       while (count > 0 && !queue.isEmpty()) {
           ans++;
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               int[] curr = queue.poll();
               for (int[] dir : dirs) {
                   int x = dir[0] + curr[0];
                   int y = dir[1] + curr[1];
                   // 坏橘子感染好橘子
                   if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                       grid[x][y] = 2;
                       count--;
                       queue.offer(new int[] {x, y});
                   }
               }
           }
       }
        return count > 0 ? -1 : ans;
    }
}