// 1413. Minimum Value to Get Positive Step by Step Sum
// Time: O(n); Space: O(1)
// 从左到右算sum，找到最小的和
// 如果sum >= 0，return 1
// 反之return -sum + 1

class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        
        return min >= 0 ? 1 : -min + 1;
    }
}