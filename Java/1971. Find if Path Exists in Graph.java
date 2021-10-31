// 1971. Find if Path Exists in Graph
// Time & Space: O(V)
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        int size = edges.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < size; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.find(start) == uf.find(end);
    }
    
    class UnionFind {
        int[] rank;
        int[] parent;
        
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
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
                    parent[rootX]= rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}




// BFS
// Time: O(V + E); Space: O(V)
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vertices.add(new ArrayList<>());
        }
		// 把点双向连接起来
        for (int i = 0; i < edges.length; i++) {
            vertices.get(edges[i][0]).add(edges[i][1]);
            vertices.get(edges[i][1]).add(edges[i][0]);
        }
        
		// O(V) sapce
		// queue中存放还未遍历的
        Queue<Integer> queue = new LinkedList<>();
		// O(V) space
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int currVertex = queue.poll();
            if (currVertex == end) {
                return true;
            }
			// 每进一次queue就是访问一次
            visited.add(currVertex);
            
            for (int vertex : vertices.get(currVertex)) {
                if (!visited.contains(vertex)) {
                    queue.offer(vertex);
                }
            }
        }
        return false;
    }
}