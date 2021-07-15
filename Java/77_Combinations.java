// 77. Combinations
// Time: O(N里面选k * N * k); 要用O(k) copy
// Space: O(k)

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), n, k, 1);  // n最小为1
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> combo, int n, int k, int start) {
        // 剪枝， temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (combo.size() + n - start + 1 < k)
            return;
        // 一条path已经出来了
        if (combo.size() == k) {
            ret.add(new ArrayList<>(combo));
            return;
        }
        // choose -> explore -> unchoose
        for (int i = start; i <= n; i++) { // 数的范围是[1, n] 所以i可以取到n
            combo.add(i);
            dfs(ret, combo, n, k, i + 1);
            combo.remove(combo.size() - 1);
        }
    }
}