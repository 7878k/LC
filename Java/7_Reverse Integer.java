// 7. Reverse Integer
// Time: O(log(X)), Space: O(1)
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // check overflow 
            if (result  < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10)
                return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}