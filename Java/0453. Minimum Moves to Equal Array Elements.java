// 453. Minimum Moves to Equal Array Elements
// Time : O(n); Space: O(1)
// 题目说每次操作使n - 1个元素增加1，反过来说就是每次操作使1个元素减少1
// 这样就题意就等价于让所有数等为最小数需要多少步操作

class Solution {
    public int minMoves(int[] nums) {
		// O(n)
        int min = Arrays.stream(nums).min().getAsInt();
        int ans = 0;
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }
}