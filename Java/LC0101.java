// 101. Symmetric Tree
// base case: 1, root == null; 2, only one root is null; 3, val is not equal
// Time & Space: O(n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
	// base case就是终止条件
    private boolean helper(TreeNode left, TreeNode right) {
		// base case 1: 左右子树都是null
        if (left == null && right == null) {
            return true;
        }
		// base case 2: 只有一个子书是null; 两个节点值不一样
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
