// 258. Add Digits
// Time: O(n); Space: O(1)

class Solution {
    public int addDigits(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;
            
			// 如果当前num < 10，就把digitRoot赋值给它
            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }
        return digitalRoot;
    }
}