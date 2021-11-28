// 98. Validate Binary Search Tree
// Time & Space: O(n)
class Solution {
	// inorder recursion 中序遍历
    private long prev = Long.MIN_VALUE; // 首先定义prev 无限的小
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;            // 二叉搜索树也可以为空！
        if (!isValidBST(root.left)) return false; // check 左子树是不是bst，如果不是就false
        if (root.val <= prev) return false;		  // 如果左子树是bst，check当前root值和prev的比较，prev是上一个节点值
        prev = root.val;						  // 因为prev是全局变量，所以在测isValidBST(root.left))之后，prev的值就变成root.left了，也就是root的上个值
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