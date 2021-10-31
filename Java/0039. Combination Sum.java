// 39. Combination Sum
// Time: O(N * 2^N); Space: O(N), N是candidates长度
// 排列问题，如果答案讲究顺序，就用visited数组 [2,2,3]和[2,3,2]不同
// 如果不讲究顺序，用begin变量，[2,2,3]和[2,3,2]相同

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null) {
            return ans;
        }
        Arrays.sort(candidates);	// 剪枝就要排序，因为如果target - candiates[i] < 0, 之后的也< 0
        backtrack(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }
    
	// begin是搜索起点，确保同一层的起点不一样
    private void backtrack(int[] candidates, int target, int begin, List<List<Integer>> ans, List<Integer> path) {
		// base case 找到了一个解
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // i = begin, 去重
		// begin是下一轮搜索的起点
		// 每一次搜索不能用同一层candidates中已经用过的元素
		// 如一个分支用了2，说明这一分支有所有包含2的答案，同层之后的就不能用2了
        for (int i = begin; i < candidates.length; i++) {
			// 剪枝（有序），如果现在是负数，减去更大的值还是负数
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
			// 递归里面i不用加一，因为可以用重复数字
            backtrack(candidates, target - candidates[i], i, ans, path);
            path.remove(path.size() - 1);
        }
    }
}	


// 不用排序
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}