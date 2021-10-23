// 695. Max Area of Island
// Time & Space: O(M * N)
// Union Find，同LC200

class Solution {
	// UnionFind 模板
    class UnionFind {
        int max;
        int[] rank;
        int[] parent;
        
        public UnionFind(int[][] grid) {
            max = 0;
            int m = grid.length;
            int n = grid[0].length;
            rank = new int[m * n];
            parent = new int[m * n];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) { // 只标记岛屿，所以当==1时候才标记
                        parent[i * n + j] = i * n + j;
                    }
                    rank[i * n + j] = 1;
                }
            }
        }
        
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                    max = Math.max(max, rank[rootX]);
                } else {
                    parent[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                    max = Math.max(max, rank[rootY]);
                }
            }
        }
        
        public int getMax() {
            return max;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
					// special case: when only one island exists 
                    uf.max = Math.max(1, uf.max);
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        return uf.getMax();
        
    }
}