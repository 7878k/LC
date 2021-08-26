// 771. Jewels and Stones
// Time: O(n); Space: O(1)

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] type = new int[58];
        for (int i = 0; i < jewels.length(); i++) {
            type[jewels.charAt(i) - 'A']++;
        }
        
        int ans = 0;
        for (int i = 0; i < stones.length(); i++) {
            ans += type[stones.charAt(i) - 'A'];
        }
        
        return ans;
    }
}