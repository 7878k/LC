// 1123. Lowest Common Ancestor of Deepest Leaves
// Time: O(N^2), Space:O(N)
class Solution {
    // 首先要找到最深的节点在哪边
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        int left = height(root.left);
        int right = height(root.right);　// 如果两边高度一样
        if (left == right) return root;  // root 肯定是lca
        else if (left > right) return lcaDeepestLeaves(root.left); // 哪边长，lca就在哪边
        else return lcaDeepestLeaves(root.right);
    }
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}