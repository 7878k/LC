// 1979. Find Greatest Common Divisor of Array
// Time: O(n + logMax); Space: O(1)

class Solution {
    public int findGCD(int[] nums) {
        int max = 0;
        int min = 1001;
        
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return gcd(max, min);
    }
    
	// 辗转相除法
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}