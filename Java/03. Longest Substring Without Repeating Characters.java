// 3. Longest Substring Without Repeating Characters
// Time: O(N); Space: O(1)

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int[] counter = new int[128];
        int res = 1;

        int left = 0;
        // 滑动窗口的逻辑是尝试向右移动一位，因此，初始值是 -1
        int right = -1;

        // 认为左边界更重要，有重复的子串，我们记录左边，舍弃右边，因此左边界如果越界了，算法停止
        while (left < len) {
            // right + 1 表示最多到 len - 1
            // counter[s.charAt(right + 1)] == 0 表示在 [left, right] 这个区间里没有出现
            if (right + 1 < len && counter[s.charAt(right + 1)] == 0) {
                // 右边第 1 个字母加入频率数组，频数 + 1
                counter[s.charAt(right + 1)]++;
                right++;
            } else {
                // 如果下一个字符已经越界了，或者右边第 1 个字母是频率数组是曾经出现过的
                // 把左边从频数数组中挪掉，频数减 1
                counter[s.charAt(left)]--;
                left++;
            }
            // 经过上面的分支，窗口 [left, right] 内一定没有重复元素，故记录最大值
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}


public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int left = 0;
        // 非空的时候，结果至少是 1 ，因此初值可以设置成为 1
        int res = 1;
        //  key 为字符，val 记录了当前读到的字符的索引，在每轮循环的最后更新
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < len; right++) {
            // 右边界没有重复的时候，直接向右边扩张就好了
            // 右边界有重复的时候，只要在滑动窗口内，我们就得更新
            // 如果在滑动窗口之外，一定是之前被计算过的
            if (map.containsKey(s.charAt(right))) {
                if (map.get(s.charAt(right)) >= left) {
                    // 下一个不重复的子串至少在之前重复的那个位置之后
                    // 【特别注意】快在这个地方，左边界直接跳到之前重复的那个位置之后
                    left = map.get(s.charAt(right)) + 1;
                }
            }
            // 此时滑动窗口内一定没有重复元素
            res = Math.max(res, right - left + 1);
            // 无论如何都更新位置
            map.put(s.charAt(right), right);
        }
        return res;
    }

}