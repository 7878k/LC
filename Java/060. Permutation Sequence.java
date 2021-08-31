// 60. Permutation Sequence
// Time: O(n^2); Space: O(n)
class Solution {
    private boolean[] visited;	// 记录数字是否使用过
    private int[] factorial ;	// 阶乘数组
    private int n;
    private int k;
    
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);
        
		// 查找全排列需要的布尔数组
        visited = new boolean[n + 1];
        StringBuilder path = new StringBuilder();
        backtrack(0, path);
        return path.toString();
    }
    
	 /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
				其实就是到了第几层
     * @param path
     */
    private void backtrack(int index, StringBuilder path) {
        if (index == n) {
            return;
        }
        
		// 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
		// 因为已经选了一个数，再选择剩下的，所以是n - 1
        int count = factorial[n - 1  - index];
        
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (count < k) {
                k -= count;
                continue;
            }
            
            path.append(i);
            visited[i] = true;
			// 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            backtrack(index + 1, path);
            return;
        }
    }
    
	/**
     * 计算阶乘数组
     *
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int [n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}