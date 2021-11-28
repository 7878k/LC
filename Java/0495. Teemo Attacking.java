// 495. Teemo Attacking
// Time: O(n); Space: O(1)

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int last = -1; // 上次攻击结束时间点
        
        for (int time : timeSeries) {
            int end = time + duration - 1;	// 中毒结束时间
            ans += last < time ? duration : end - last;
            last = end;
        }
        
        return ans;
    }
}


class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int resetTime = 0;
        
        for (int time : timeSeries) {
            if (time >= resetTime) {
                ans += duration;
            } else {
                ans += time + duration - resetTime;
            }
            resetTime = time + duration;
        }
        
        return ans;
    }
}