// 869. Reordered Power of 2
// Time : O(logn); Space: O(1)
class Solution {
    Set<String> powerOf2Digits = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }
    
    private void init() {
		// 注意n的范围
        for (int i = 1; i < 1e9; i <<= 1) {
            powerOf2Digits.add(countDigits(i));
        }
    }
    
    private String countDigits(int n) {
        char[] count = new char[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        return new String(count);
    }
}