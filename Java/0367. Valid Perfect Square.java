// 367. Valid Perfect Square
// Time: O(nlogn), Sapce: O(1)
// spend : 2min
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        
        while (left <= right) {
            int mid = left + right >> 1;
            long square = (long) mid * mid;
            
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return false;
    }
}