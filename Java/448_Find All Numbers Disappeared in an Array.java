// 448. Find All Numbers Disappeared in an Array
// Time： O(n), Space: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n; // 还原x， 因为array是从1开始，所以-1
            nums[x] += n;          // 每个位置都+n， 如果最后<=n, 说明这个数原来不存在
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {  // i是index，最后的结果要+1
                ret.add(i + 1);  // i位置上的值是i+1
            }
        }
        return ret;
    }
}