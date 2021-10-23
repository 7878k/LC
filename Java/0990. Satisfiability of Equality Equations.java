// 990. Satisfiability of Equality Equations
// Time: O(n); Space: O(1)

class Solution {
    public boolean equationsPossible(String[] equations) {
        if (equations == null) {
            return false;
        }
        
        int size = 26;
        UnionFind uf = new UnionFind(size);
        
		// 先把有等号的连在一起
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                uf.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        
		// 如果有不等号并且还连在一起，等式就不成立
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                if (uf.find(str.charAt(0) - 'a') == uf.find(str.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
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