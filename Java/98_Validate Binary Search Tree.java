// 98. Validate Binary Search Tree
// Time & Space: O(n)
class Solution {
	// inorder recursion
    private long prev = Long.MIN_VALUE; // 首先定义prev 无限的小
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;  // 如果root是null肯定是bst
        if (!isValidBST(root.left)) return false; // check 左子树是不是bst，如果不是就false
        if (root.val <= prev) return false;		  // 如果左子树是bst，check当前root值和prev的比较，prev是上一个节点值
        prev = root.val;						  // 如果左子树也是bst，那么把prev的值变成左子树
        return isValidBST(root.right);            // check 右子树是不是bst
    }
}


class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // 根据边界来判断，左子树肯定小于root，右子树肯定大于root
    private boolean helper(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower | root.val >= upper) return false;
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
}