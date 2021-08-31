// 188. Best Time to Buy and Sell Stock IV
// Time: O(nk); Space: O(k)

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
		// base case
        if (k == 0 || len < 2) {
            return 0;
        }
        
		// 每次交易需要2个数，所以k最高是 len/2 = len>>1
        k = Math.min(k, len >> 1);
		// buy会减少手头资金，sell会增加手头资金
        int[] buy = new int[k];
        int[] sell = new int[k];
		// buy默认就是买第一个，这样对现在来讲，后面所有的手头资金都是-prices[0]
        Arrays.fill(buy, -prices[0]);
        
		// 定义完成一次buy + sell是一次交易，也就是k++
		// buy[k]之后的sell还是sell[k]
		// buy[k]之前的sell是sell[k-1]
        for (int i = 1; i < len; i++) {
			// buy[0]的时候，要么之前买了这时候没买；或者这次买了，买需要钱，-prices[i]
            buy[0] = Math.max(buy[0], -prices[i]);
			// sell[0]的时候，要么之前卖了这时候没卖；或者这次卖了，卖的话就赚钱，就是+prices[i]
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];
    }
}