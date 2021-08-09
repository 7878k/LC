// 875. Koko Eating Bananas
// Time: O(NlogW); Space:O(1), N是香蕉堆的数量，W是最大香蕉堆的大小~
// 每堆的大小就是当前堆的最大速度

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 1;
        for (int speed : piles) {
            maxSpeed = Math.max(maxSpeed, speed);
        }
		
		// 速度最小的时候，耗时最长
        int left = 1;
		// 速度最大的时候，耗时最短
        int right = maxSpeed;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (totalHours(piles, mid) > h) {
				// 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int totalHours(int[] piles, int speed) {
        int total = 0;
        for (int pile : piles) {
			// 向上取整速度
            total += (pile + speed - 1) / speed;
        }
        return total;
    }
}