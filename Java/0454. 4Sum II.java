// 454. 4Sum II
// Time: O(n^2); Space:O(n^2)
// 把前面两个数组和放到map，然后用后面两个数组的和的负数查询

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int u : nums1) {
            for (int v : nums2) {
                map.put(u + v, map.getOrDefault(u + v, 0) + 1);
            }
        }
        
        int ans = 0;
        
        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(- i - j)) {
                    ans += map.get(- i - j);
                }
            }
        }
        return ans;
    }
}