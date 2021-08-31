// 39. Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null) {
            return ans;
        }
        
        Arrays.sort(candidates);	// 剪枝就要排序
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
        
        for (int i = begin; i < candidates.length; i++) {
			// 每一次搜索的时候设置 下一轮搜索的起点 begin，不能用同一层已经用过的元素
			// 剪枝（有序），如果现在是负数，减去更大的值还是负数
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, ans, path);
            path.remove(path.size() - 1);
        }
    }
}	