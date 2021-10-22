// 476. Number Complement
// Time: O(loglognum); Space: O(1)
// spend: 10min
class Solution {
    public int findComplement(int num) {
        int bitmask = num;
		// propagate the highest 1-bit 
		// |或运算两个位都是 0 时，结果才为 0，否则为 1
        bitmask |= (bitmask >> 1);
        bitmask |= (bitmask >> 2);
        bitmask |= (bitmask >> 4);
        bitmask |= (bitmask >> 8);
        bitmask |= (bitmask >> 16);
		// 这样之后高位1和低位1之间都是1
        
		// ^ 异或运算： 两个位相同则为 0，不同则为 1
        return bitmask ^ num;
    }
}