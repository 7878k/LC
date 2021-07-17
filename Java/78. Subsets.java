// 78. Subsets
// Time: O(N* 2^n); Space:O(n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), nums, 0);
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> path, int[] nums, int start) { 
        ret.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {  // 如果需要不重复的结果，就i = start， 否则是0
            path.add(nums[i]);  // i是当前访问的index的坐标
            dfs(ret, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}