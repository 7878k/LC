// 1017. Convert to Base -2
// Time & Space: O(logn)

class Solution {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            res.append(n & 1);
            n = -(n >> 1);
        }
        return res.reverse().toString();
    }
}