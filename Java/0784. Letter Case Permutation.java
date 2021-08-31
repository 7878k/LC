// 784. Letter Case Permutation
// Time: O(2^n * n); Space: O(2^n * n)
// 如果下一个字符是字母，就遍历字符串，然后复制2份：大小写
// 如果是数字，就直接加在后面
 
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, ans, new StringBuilder());
        return ans;
    }
    
    private void backtrack(String s, int index, List<String> ans, StringBuilder path) {
        if (path.length() == s.length()) {
            ans.add(path.toString());
            return;
        }
        
        char ch = s.charAt(index);
        if (Character.isDigit(ch)) {
            path.append(ch);
            backtrack(s, index + 1, ans, path);
            path.setLength(path.length() - 1);
        } else {
            path.append(Character.toLowerCase(ch));
            backtrack(s, index + 1, ans, path);
            path.setLength(path.length() - 1);
            
            path.append(Character.toUpperCase(ch));
            backtrack(s, index + 1, ans, path);
            path.setLength(path.length() - 1);
        }
    }
}