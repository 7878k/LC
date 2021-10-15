// 787. Cheapest Flights Within K Stops
// Time: O(m + n)*k; Space: O(nk)

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
		// 最多k+1次航班，所以<= k+1
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



// Time: O(k * n^2); Space: O(n)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 由于最多中转k次，所以最多搭乘k+1次航班
        // price花费不超过10^4，最多k+1次航班(101)，所以极大值要大于这个数
        final int INF = 1000 * 101 + 1;
        // srcInfo储存某个节点到所有子节点的花费
        List<int[]>[] srcInfo = new List[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            srcInfo[i] = new ArrayList<>();
        }
        // example: g[0] = [[1, 100], [2, 500]]
        // 当前在0， 0->1 cost 100； 0->2 cost 500
        for (int[] flight : flights) {
            srcInfo[flight[0]].add(new int[] {flight[1], flight[2]});
        }
        
        // ans储存从起点到某个点的花费
        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        // queue储存src到某个点需要的花费
        Queue<int[]> queue = new LinkedList<>();
        // 从src到src需要0
        queue.offer(new int[] {src, 0});
        
        // bfs, k个stop，最多飞k + 1次，所以判断k + 1 > 0
        while (!queue.isEmpty() && k + 1 > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // poll[] 储存从src到当前点需要的花费
                // poll[0] : src; poll[1]: cost
                int[] poll = queue.poll();
                for (int[] path : srcInfo[poll[0]]) {
                    // 当前的花费 = 这个点之前的花费 + 之前点到当前点的花费
                    int currCost = poll[1] + path[1];
                    // pruning 1: 当前花费比之前算的少; 当前花费比之前的总cost少
                    if (currCost < ans[path[0]] && currCost < ans[dst]) {
                        ans[path[0]] = currCost;
                        // pruning 2: 如果还没到中点, 放入queue后继续算
                        if (path[0] != dst) {
                            queue.offer(new int[] {path[0], currCost});
                        }
                    }
                }
            }
            k--;    // 每飞一个stop就减少1
        }
        return ans[dst] == INF ? -1 : ans[dst];
    }
}