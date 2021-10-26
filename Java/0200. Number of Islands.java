// 200. Number of Islands
// UnionFind solution
// Time & Space: O(M * N) 

class Solution {
    class UnionFind {
        int count;
        int[] rank;
        int[] parent;
        
		// 加权 & 路径压缩 并查集
        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            rank = new int[m * n];
            parent = new int[m * n];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 1;
                }
            }
        }
        
		// 路径压缩
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        
		// 加权
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
				if (rank[rootX] > rank[rootY]) {
					parent[rootY] = rootX;
				} else if (rank[rootX] < rank[rootY]) {
					parent[rootX] = rootY;
				} else {
					parent[rootY] = rootX;
					rank[rootX] += 1;
				}
                count--;
			}	
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int numIslands(char[][] grid) {
		// base case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
				// 还要检测当前是否为1，不然可能出现一个是1，另一个不是1
                if (grid[i][j] == '1') {
					// 只需要检测左和上，因为右边能连通，左边也能，上下也一样
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * cols + j, (i - 1) * cols + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * cols + j, i * cols + j - 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}