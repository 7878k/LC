// 844. Backspace String Compare
// Time & Space: O(M + N) m, n are lengths 

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch == '#') {
                if (sb.length() > 0) // 切记要判断当前有没有char去删除！
                    sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}


// Time: O(N + M); Space: O(1)
// 双指针从后往前看，因为退格符只影响前面的那个字符
// 设定两个skip记录2个string的退格符，如果碰到#， skip + 1
// 如果碰到字符并且当前skip > 0， 那继续往前走 并且skip - 1

class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            // 先找到 s 中第一个需要比较的字符（即去除 # 影响后的第一个待比较字符）
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // 再找到 t 中第一个需要比较的字符（即去除 # 影响后的第一个待比较字符）
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // 只有 i j 都大于等于0才能比较
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
                // 如果有一个不是大于0的，那么说明有一个没找到待比较字符
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            // 进行下一轮比较
            i--;
            j--;
        }
        return true;
    }
}

