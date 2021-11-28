// 448. Find All Numbers Disappeared in an Array
// Time： O(n), Space: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
			// 获取每个num代表的位置，如果大于0，就把那个位置的数取反
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < len; i++) {
			// 最后如果有正数，那肯定这个数不是应有的number
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
    
}