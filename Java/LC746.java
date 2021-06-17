// 746. Min Cost Climbing Stairs	
// Time: O(n), Space: O(1)
// 这题要登顶， 可以认为 在int[] cost 后还有个顶需要登上，所以有i <= lenth
// prev, curr 代表到达前一层和当前层的min cost
// sliding window 每次比较prev/curr + 这一层的cost，要算上n因为n是top
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int prev = 0;
        int curr = 0;
        
        // 当 i >= 2的时候， 才和前两层有关
        for (int i = 2; i <= length; i++) {
            int next = Math.min(prev + cost[i - 2], curr + cost[i - 1]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}