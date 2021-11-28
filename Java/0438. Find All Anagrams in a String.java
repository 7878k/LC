// 438. Find All Anagrams in a String
// Time: O(n); Space: O(1)

/**
因为字符串中的字符全是小写字母，可以用长度为26的数组记录字母出现的次数
设n = len(s), m = len(p)。记录p字符串的字母频次p_cnt，和s字符串前m个字母频次s_cnt
若p_cnt和s_cnt相等，则找到第一个异位词索引 0
继续遍历s字符串索引为[m, n)的字母，在s_cnt中每次增加一个新字母，去除一个旧字母
判断p_cnt和s_cnt是否相等，相等则在返回值res中新增异位词索引 i - m + 1
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) return ans;
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = n; i < m; i++) {
            sCount[s.charAt(i - n) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - n + 1);
            }
        }
        return ans;
    }
}