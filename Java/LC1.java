// 1. Two Sum
// Time: O(n), space: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int add = nums[i];
            if (map.containsKey(target - add))
                return new int[]{i, map.get(target - add)};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}