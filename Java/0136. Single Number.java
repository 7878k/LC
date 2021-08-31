// 136. Single Number
// time: o(n); space: o(1)
// a xor 0 = a; a xor a = 0; a xor b xor a = a xor a xor b 

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums)
            a^=i;
        return a;
    }
}