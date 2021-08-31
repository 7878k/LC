// 560. Subarray Sum Equals K
// Time: O(n); Space: O(n)
// 用前缀和解决， preSum - k
// 如果有从0开始的subarry和是preSum - k, 那后面的subarray和就是k

class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 和为0出现了1次
        int preSum = 0;
        int count = 0;
        
        for (int i = 0; i < length; i++) {
            preSum += nums[i];
            
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}