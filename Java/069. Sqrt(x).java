// 69. Sqrt(x)
// Time: O(logx); Space: O(1)

class Solution {
    public int mySqrt(int x) {
		// base case
        if (x == 0 || x == 1) {
            return x;
        }
        
        int left = 1;
		// 一个数的平方根不会超过它的一半
        int right = x / 2;
        
		// 用left < right是因为退出循环的时候 return哪个都行
		// 并且存在两个区间： 1，一定没有target； 2，可能有target
        while (left < right) {
			// mid 向上取整，如果不+1，再[mid, right]的时候会死循环
            int mid = left + (right - left + 1) / 2;
			// 如果mid^2 大于x，mid肯定不是答案，向左搜
            if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}