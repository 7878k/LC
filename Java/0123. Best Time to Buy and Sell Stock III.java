// Time: O(n); Space: O(1)
// SPEND: 10min
// 四个状态，分别表示买/卖后手里的钱

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 最开始手里钱是负数，或者0
        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sell1 = 0;
        int sell2 = 0;
        
        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            // 计算sell1时，用的还是buy1，
            // 因为昨天的buy1'在今天sell1后没有影响
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        
		// 最后出现三种情况，0，sell1，sell2，
		// 转移过程种维护的是最大值，所以都大于等于0
		// 因为同一天买卖不影响结果，最终答案肯定可以转移到sell2
        return sell2;
    }
}