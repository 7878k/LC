// 47. Permutations II
// Time O(N * N!), Space: O(N)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) 
            return ret;
        Arrays.sort(nums); // 要记得sort, 不然判断重复值没有意义
        dfs(nums, ret, new ArrayList<>(), new boolean[nums.length]);
        return ret;
    }
    
    private void dfs(int[] nums, List<List<Integer>> ret, List<Integer> path, boolean[] visited) {
        if (nums.length == path.size()) {
            ret.add(new ArrayList<>(path));
            return;
        }
        
        // 因为有重复的，所以访问过的就跳过
        // 如果不是第一个值并且前后两个值相同，而且第一个值没访问过，就要跳过
        // 因为会出现两个1 1 2 这种情况
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) 
                continue;
            visited[i] = true;
            path.add(nums[i]);
            
            dfs(nums, ret, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}