// 787. Cheapest Flights Within K Stops
// Time: O(m +_n)*k; Space: O(nk)

// 转移方程：f[t][i] = f[t - 1][i] + cost(j, i)
// 通过t次航班，从src城市到达城市i所需要的最小花费
// j是最后一次航班的起点
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 当t = 0，如果i是src，花费为0
        // 如果i不是src，说明状态不合法，这里定义成极大值
		// 由于最多中转k次，所以最多搭乘k+1次航班
        // price花费不超过10^4，最多k+1次航班(101)，所以极大值要大于这个数
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                // j是最后一个起点，所以是i之前的src，i就是dst
                int j = flight[0], i = flight[1], cost = flight[2];
                // 状态转移
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        // 最多中转k次，就有k + 1次航班
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }
}