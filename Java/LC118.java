// 118. Pascal's Triangle
// Time: O(n^2), Space: O(1) 
// 如果该空间只是存储返回的内容，那么不计算在空间复杂度
// 每行的第一个和最后一个都是1
// 中间的数等于上一行的数 + 上一行的左边的数。

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            // 当前行的arraylist
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(answer.get(i - 1).get(j) + answer.get(i - 1).get(j - 1));
            }
            answer.add(row);
        }
        return answer;
    }
}