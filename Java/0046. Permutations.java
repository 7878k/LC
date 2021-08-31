// 46. Permutations
// Time O(N * N!), Space: O(N)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) {
            return ret;
        }
        
        dfs(nums, new boolean[nums.length], new ArrayList<>(), ret);
        
        return ret;
        
    }
    
    // 用visit记录当前index访问过没有
    private void dfs(int[] nums, boolean[] visited, 
                    List<Integer> path, List<List<Integer>> ret) { // argument没记录start，所以要查重
        if (nums.length == path.size()) {   // base case 当前path已经走完了
            ret.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {      // 如果没有访问过，就加入当前path * 记得要检查 忘记好多次了
                path.add(nums[i]);  // choose
                visited[i] = true;
                
                dfs(nums, visited, path, ret); // explore (recursion call)
                // 回溯 跟之前做相反操作 unchoose         
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}