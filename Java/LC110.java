// 110. Balanced Binary Tree
// Time & Space : O(n)
// use -1 to denote the tree is not balanced/
// >=0 value means the tree is balanced and it is the height of the tree

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0; // 如果height不是-1 就说明是bst same as : height(root) != -1
    }
    
    // 算tree的高度，凡是不是bst都返回-1，然后check最后的值
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
		
        int left = height(root.left);
        int right = height(root.right);
		
        // 只要height是-1就不平衡，如果左右子树高度大于1，也不是平衡
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}