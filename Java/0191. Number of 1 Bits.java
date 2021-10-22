// 191. Number of 1 Bits
// Time: O(logn); Space: O(1)

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        
        while (n != 0) {
            n -= lowbit(n); // 每次减去n的最后一位1
            res++;
        }
        
        return res;
    }
    
	// 返回x的最后一位1
    private int lowbit(int x) {
        return x & -x;
    }
}