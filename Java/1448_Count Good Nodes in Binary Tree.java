// 1448. Count Good Nodes in Binary Tree
// Time: O(n), Space: O(n)
// 自上而下传的是node path的最大值
class Solution {
    private int result;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return result;
    }
    
    // backtracking 一般写成void
    private void dfs(TreeNode root, int max) {
        if (root == null) 
            return;
        if (root.val >= max) // 如果root.val >= max 说明是good node
            result++;
        dfs(root.left, Math.max(root.val, max));
        dfs(root.right, Math.max(root.val, max));
    }
}