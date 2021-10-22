// 66. Plus One
// Time: O(n), Space:O(1)
// 1，直接在最后+1；2，最后有若干9，找到第一个不是9的把它+1，然后后面
// 全部变成0；3，全部都是0，那就return一个新数组，是原来数组前面加一个1

class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        
        int[] ans = new int[length + 1];
        ans[0] = 1;
        return ans;
    }
}