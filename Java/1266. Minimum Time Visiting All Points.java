// 1266. Minimum Time Visiting All Points
// Time: O(n); Space: O(1)
// 切比雪夫距离 Chebyshev distance

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x0 = points[0][0];
        int y0 = points[0][1];
        int ans = 0;
        int length = points.length;
        
        for (int i = 1; i < length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            ans += Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0));
            x0 = x1;
            y0 = y1;
        }
        
        return ans;
    }
}