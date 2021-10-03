// 50. Pow(x, n)
// Time: O(logn); Space: O(1)

class Solution {
    public double myPow(double x, int n) {
        long num = n;
		// 如果x是负数，指数变复数，然后再去倒数
        return num > 0 ? fastPow(x, num) : 1.0 / fastPow(x, -num);
    }
    
	// 快速幂
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        
        double res = 1.0;
        
        while (n > 0) {
			// 如果次方是奇数，就要多乘1个
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
			// 除以2
            n >>= 1;
        }
        return res;
    }
}