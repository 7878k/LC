// 1101. The Earliest Moment When Everyone Become Friends
// Time: O(E + mlogm); Space: O(n), m是logs的个数，E是edges数量

class Solution {
    class UnionFind {
        int[] rank;
        int[] parent;
        
        public UnionFind(int size) {
            rank = new int[size];
            parent = new int[size];
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
                    rank[rootX]++;
                }
            }
        }
    }
    
    public int earliestAcq(int[][] logs, int n) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(logs, (log1, log2) -> (log1[0] - log2[0]));
        for (int[] log : logs) {
            uf.union(log[1], log[2]);
            if (uf.count == 1) return log[0];
        }
        return -1;
    }
}