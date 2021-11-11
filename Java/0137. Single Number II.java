// 137. Single Number II
// Time: O(nlogC); Space: O(1); C = 32
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
		// 32 int range
		// 答案的第i个bit可能是0/1
		// 算出每一位
		// 答案的第i个bit就是所有元素第i个bit之和除以3的余数
        for (int i = 0; i < 32; i++) {
            int total = 0;
			// 重复的数的第i位肯定是3的倍数，要么0，要么3
			// 这样算所有第i位，3的倍数多出来的那位就是答案的第i位
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
			// 把第i位放到对应的位置
			// it sets the i'th bit of ans to 1
            if (total % 3 != 0) {
                ans |= (1 << i); // 1<<i i left-shifted by i
            }
        }
        return ans;
    }
}


// Time & Space: O(n)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : map.keySet()) {
            if (map.get(x) == 1) return x;
        }
        return -1;
    }
}