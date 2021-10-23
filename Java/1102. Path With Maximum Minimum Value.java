// 1102. Path With Maximum Minimum Value
// Time: O(mnlogmn); Space: O(mn)

class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    int min1 = Math.min(grid[i][j], grid[i - 1][j]);
                    edges.add(new int[] {min1, i * n + j, (i - 1) * n + j});                      
                }
                if (j - 1 >= 0) {
                    int min2 = Math.min(grid[i][j], grid[i][j - 1]);
                    edges.add(new int[] {min2, i * n + j, i * n + j - 1});  
                }
            }
        }
        
        Collections.sort(edges, (a, b) -> (b[0] - a[0]));
        UnionFind uf = new UnionFind(size);
        
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.find(0) == uf.find(size - 1)) return edge[0];
        }
        return 0;
    }
    
    class UnionFind {
        int[] rank;
        int[] parent;

        public UnionFind(int size) {
            rank = new int[size];
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i]  = i;
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
                if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
                else if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
                else parent[rootY] = rootX; rank[rootX]++;
            }
        }

    }
}