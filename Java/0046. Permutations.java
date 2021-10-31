// 46. Permutations
// Time: O(n * n!), 一共n！个结果，每次复制一遍需要O(n)
// Space: O(n); 递归了n次
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



// 不用visited数组
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        for (int num : nums) {
            path.add(num);
        }
        
        helper(nums.length, ans, path, 0);
        return ans;
    }
    // index是下一个要填的位置，不是当前位置
    private void helper(int length, List<List<Integer>> ans, List<Integer> path, int index) {
        if (index == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
		// 每个循环i变成当前index
        for (int i = index; i < length; i++) {
            Collections.swap(path, index, i);
            helper(length, ans, path, index + 1);
            Collections.swap(path, index, i);
        }
    }
}