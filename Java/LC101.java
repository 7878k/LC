// 101. Symmetric Tree
// base case: 1, root == null; 2, only one root is null; 3, val is not equal
// Time & Space: O(n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}