// 90. Subsets II
// Time: O(N* 2^n); Space:O(n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);  // 要先sort了才能判断2个相邻的数是否相同
        dfs(ret, new ArrayList<>(), nums, 0);
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> path, int[] nums, int start) {
        ret.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if ( i != start && nums[i] == nums[i - 1]) { // 判断这个数是不是第一次出现，并且不和前面的数相同
                continue;
            }
            path.add(nums[i]);
            dfs(ret, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}