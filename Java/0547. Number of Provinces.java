// 547. Number of Provinces
// Time: O(n^2); Space: O(n)
// 一共有n个节点，每一个row只是一个节点

class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        
        public UnionFind(int size) {
            count = 0;
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(rank, 1);
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                count++;
            }
        }
        
        public int find(int x) {
            if (x == parent[x]) return x;
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
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int size = isConnected.length;
        UnionFind uf = new UnionFind(size);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isConnected[i][j] == 1 && i != j)
                    uf.union(i, j);
            }
        }
        return uf.getCount();
    }
}