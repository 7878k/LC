// 216. Combination Sum III
// Time: O(m * 2^m); Space: O(m)

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k, n, 1, ans, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(int k, int n, int start, List<List<Integer>> ans, 
                           List<Integer> path) {
        if (n == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (n - i < 0) {
                break;
            }  
            path.add(i);
            backtrack(k, n - i, i + 1, ans, path);
            path.remove(path.size() - 1);
        }
    }
}