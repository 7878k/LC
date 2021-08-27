// 1232. Check If It Is a Straight Line
// Time: O(n); Space: O(1)

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
		// (x0, y0), (x1, y1) 是线上的2个点
		// 那么第三个点必须满足 (y-y1)*(x1-x0) = (y1-y0)*(x-x1)
        int x0 = coordinates[0][0], y0 = coordinates[0][1], 
            x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}