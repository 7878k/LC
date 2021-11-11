// 268. Missing Number
// Time: O(n); Space: O(1)
// 在nums后面接上0到n共n+1个数
// missing number肯定出现在前一段，其他所有数
// 都重复2次

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int ans = 0;
        
        for (int num : nums) {
            ans ^= num;
        }
        for (int i = 0; i <= len; i++) {
            ans ^= i;
        }
        
        return ans;
    }
}


class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }
}