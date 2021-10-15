// 38. Count and Say
// Time : O(N * M) M为res的最大长度; Space: O(M)
// Spend: 20 min

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        
        for (int i = 2; i <= n; i++) {
			// 每次循环完要重置start, curr的位置
            int start = 0;
            int curr = 0;
            int length = res.length();
			// StringBuilder也要重置
            StringBuilder sb = new StringBuilder();
            
            while (curr < length) {
                while (curr < length && res.charAt(curr) == res.charAt(start)) {
                    curr++;
                }
                sb.append(Integer.toString(curr - start)).append(res.charAt(start));
                start = curr;
            }
            res = sb.toString(); 	// res每次循环要更新
        }
        
        return res;
    }
}