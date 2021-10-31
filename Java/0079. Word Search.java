// 79. Word Search
// Time: (MN*3^L); Space: O(MN), L是字符串word的长度
// 除了第一次有四个走法，后面最多只有三个走法，因为不能回退。
// 检测一个字符是3^L, 要检测MN次
// spend: 30min 

class Solution {
    int rows, cols;
    char[][] board;
    char[] word;
	// 按照右下左上这个顺序查找字母
    int[][] next = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word.toCharArray();
        this.visited = new boolean[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }
    
	// index是当前坐标
    private boolean backtrack(int index, int row, int col) {
		// visited[row][col] 说明走完了都没有找到
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return false;
        }
        // 不匹配直接false
        if (board[row][col] != word[index]) {
            return false;
        }
        // 匹配当前字母并且已经到了最后一个字母，直接true
        if (index == word.length - 1) {
            return true;
        }
        // 标记访问过的节点
        visited[row][col] = true;
        // 访问四个方向
        for (int[] direction : next) {
			// 前面已经判断所有false的条件，如果能到这里是true，那这个path肯定是答案
            if (backtrack(index + 1, row + direction[0], col + direction[1])) {
                return true;
            }
        }
		// 如果出来了，说明这个起点的所有path都没有答案，一定要回溯！
        // 状态回溯
        visited[row][col] = false;
        return false;
    }
}