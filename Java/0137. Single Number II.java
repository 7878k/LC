// 137. Single Number II
// Time: O(nlogC); Space: O(1); C = 32
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
			// 重复的数的第i位肯定是3的倍数，要么0，要么3
			// 这样算所有第i位，3的倍数多出来的那位就是答案的第i位
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
			// 把第i位放到对应的位置
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}


// Time & Space: O(n)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}