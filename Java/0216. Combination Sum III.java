// 216. Combination Sum III
// Time: ((m, k) * k); Space: O(k); m是集合个数，为9


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
		// 1 - 9
        backtrack(k, n, 1, ans, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(int k, int n, int start, List<List<Integer>> ans, 
                           List<Integer> path) {
		// base case
        if (n == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
			// corner case
            if (n - i < 0) {
                break;
            }  
            path.add(i);
			// 下一轮i+1去重
            backtrack(k, n - i, i + 1, ans, path);
            path.remove(path.size() - 1);
        }
    }
}