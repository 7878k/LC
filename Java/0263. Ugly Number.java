// 263. Ugly Number
// Time: O(logn); Space: O(1)

//  ugly number n:  2^x * 3^y * 5^z = n
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        
        return n == 1;
    }
}