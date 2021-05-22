// 69. Sqrt(x)
// time: O(log(x)), space: O(1)
// 因为要取mid或者比mid小的最大的，那么 小于等于x的时候在一起处理

class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int answer = -1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if ((long) mid * mid <= x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}