// 261. Graph Valid Tree
// Time: O(n); Space: O(n);
// 判断点能不能构成树:
// 1: 如果有cirlce就不是树，图里就是两个点parent一样
// 2： 如果最后所有点都union，然是节点个数超过1，就不是树

class Solution {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        
        public UnionFind(int size) {
            count = size;
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
        
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
            return true;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            } 
        }
        return uf.getCount() ==  1;
    }
}