// 500. Keyboard Row
// Time: O(L); Space: O(C)
// L是所有word加起来长度，C是26
class Solution {
    public String[] findWords(String[] words) {
		// 记录abcd...xyz每个字母所在的行数
        String rowIdx = "12210111011122000010020202";
        List<String> list = new ArrayList<>();
        for (String str : words) {
            boolean isValid = true;
			// 获取第一个行数
            char index = rowIdx.charAt(Character.toLowerCase(str.charAt(0)) - 'a');
            int len = str.length();
            for (int i = 1; i < len; i++) {
				// 对比当前行数是不是和第一个相同
                if (rowIdx.charAt(Character.toLowerCase(str.charAt(i)) - 'a') != index) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) list.add(str);
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}