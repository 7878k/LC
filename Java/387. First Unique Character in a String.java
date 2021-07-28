// 387. First Unique Character in a String
// Time: O(N); Space: O(1)
// 把每个char放到array里然后最后看这个char是不是等于1
// char - 'a'就是把它转换为int
class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            freq[s.charAt(i) - 'a']++; 
        }
        
        for (int i = 0; i < length; i++) {
            if (freq[s.charAt(i) - 'a']  == 1)
                return i;
        }
        
        return -1;
    }
}