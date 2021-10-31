// 260. Single Number III
// Time: O(n); Space: O(1)

class Solution {
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
		// 其他有2个相同的num异或后都变成0，只剩下x，y
        for (int num : nums) {
			// x ^ y = xorsum
			// x ^ x ^ y = x ^ xorsum
			// y = x ^ xorsum
            xorsum ^= num;
        }
		// 算最低位1
        int lowbit = xorsum & -xorsum;
        
        int x = 0; 
        int y = 0;
		// num中分为两位，lowbit那位设为第l位
		// 不同的两个数的l位肯定不同，这样lowbit才是1
		// num现在分为两类，l位是0或者1
		// x y肯定在不同类
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                x ^= num;
            } //else {
                //y ^= num;
            //}
        }
        return new int[] {x, x ^ xorsum};
    }
}