// 1631. Path With Minimum Effort
// Time: O(mn * logmn); Space: O(m * n)
// spent: 60min

class Solution {
	// uf模板
    class UnionFind {
        int[] parent;    
        int[] rank;
        
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            
            Arrays.fill(rank, 1);
            for (int i = 0; i < size; i++) {
                parent[i] = i;
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
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
    }
    
    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int m = heights.length;
        int n = heights[0].length;
		// 把生成的所有边放到edges
		// edge[0] 边的权重； edge[1]：边的第一个顶点； edge[2]：边的第二个顶点
        List<int[]> edges = new ArrayList<>();
        int size = m * n;
        
		// uf模板 要遍历每个点，所以i, j初始化都为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    edges.add(new int[] {Math.abs(heights[i][j] - heights[i - 1][j]), i * n + j, (i - 1) * n + j});
                }
                if (j - 1 >= 0) {
                    edges.add(new int[] {Math.abs(heights[i][j] - heights[i][j - 1]), i * n + j, i * n + j - 1});
                }
            }
        }
        
		// 按权重排序
        Collections.sort(edges, (edge1, edge2) -> edge1[0] - edge2[0]);
        UnionFind uf = new UnionFind(size);
        
		// 遍历所有边，判断左上角和右下角两个节点是否连通
		// 连通就是拥有同一个父节点
		// 因为是从小到大开始算，所以第一个找到的答案就是最小值
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.find(0) == uf.find(size - 1)) {
                return edge[0];
            }
        }
        return 0;
    }
}