// 226. Invert Binary Tree
// Time % Space: O(n)
// reverse left & right, then make reverse root.left and root.right

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
        
    }
}