	// 77. Combinations
// Time: O(N里面选k * k); 要用O(k) copy
// Space: O(k)

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
		// 本来就是按顺序的，不用排序了
		if (n < k || k <= 0) {
            return ret;
        }
        dfs(ret, new ArrayList<>(), n, k, 1);  // n最小为1，为题目设定
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> combo, int n, int k, int start) {
		// 选到后面，可选元素越来越少，又不能选前面的重复元素，就会出现加起来小于k的情况
        // 剪枝， temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (combo.size() + n - start + 1 < k)
            return;
        // 递归终止条件是：path 的长度等于 k
        if (combo.size() == k) {
            ret.add(new ArrayList<>(combo));
            return;
        }
        // choose -> explore -> unchoose
		// [1, 2, 3, 4]; 第一轮[1] 选2，3，4； 第二轮[2] 选 3, 4；1就不选了因为已经选过了
		// 遍历可能的搜索起点
        for (int i = start; i <= n; i++) { // 数的范围是[1, n] 所以i可以取到n
            combo.add(i);
			// 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(ret, combo, n, k, i + 1);
			// 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            combo.remove(combo.size() - 1);
        }
    }
}