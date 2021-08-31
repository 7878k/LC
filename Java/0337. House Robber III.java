// 337. House Robber III
// Time: O(n); Space: O(n)
// 二叉树中只存在两种情况，选f(node), 不选g(node)
// 如果选择，那么最大值就是f(node) = node.val + g(left) + g(right)
// 因为选择当前node，就不能选子树，所以是当前值，加上不选左右子树的最大值
// 如果不选，那么最大值就是g(node) = Math.max(f(left), g(left)) + Math.max(f(right), g(right))
// 当前值不选的话，左右子树可选可不选

class Solution {
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root); 
        return Math.max(rootStatus[0], rootStatus[1]);
    }
    
    private int[] dfs(TreeNode node) {
		// base case
        if (node == null) {
            return new int[]{0, 0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = node.val + left[1] + right[1];
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
		// 0: 选; 1: 不选
        return new int[]{selected, notSelected};
    }
}