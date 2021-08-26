// 40. Combination Sum II
// Time: O(N * 2^N); Space: O(N)
// 同39

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null) {
            return ans;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(int[] candidates, int target, int begin, List<List<Integer>> ans, List<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = begin; i < candidates.length; i++) {
			// 大剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝
			// i > begin i目前不是begin，现在是同层，不能出现相同元素，就不能选
			// 同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            path.add(candidates[i]);
			// i + 1是因为不能选重复的数
            backtrack(candidates, target - candidates[i], i + 1, ans, path);
            path.remove(path.size() - 1);
        }
    }
}