// 17. Letter Combinations of a Phone Number
// Time: O(3^m * 4^n); Space:O(m + n);  m是位数3的数字个数，n是位数4的数字个数

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character, String> map= Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"); 
        
		// 字符串的回溯就用StringBuilder
        backtrack(digits, ans, 0, map, new StringBuilder());
        return ans;
    }
    
    private void backtrack(String digits, List<String> ans, int index, Map<Character, String>                               map, StringBuilder path) {
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        int length = letters.length();
        
        for (int i = 0; i < length; i++) {
            path.append(letters.charAt(i));
            backtrack(digits, ans, index + 1, map, path);
            path.deleteCharAt(index);
        }
        
    }
    
}