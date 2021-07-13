// 236. Lowest Common Ancestor of a Binary Tree
// TIME & SPACE: O(N)
class Solution {
	// 二叉树的最近公共祖先，如果其中一个node是root，那么它就是答案
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 这个是如果其中一个root就是p/q，那么它就是答案
		// 也可以检测其中的字数是不是包含p/q
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
		// 
        if (left != null && right != null) // 如果p/q分别在不同子树，ROOT就是答案
            return root;
        if (left == null) // 如果是null，答案肯定在right
            return right;
        if (right == null) // vive versa
            return left;
        return null; // 如果都没有就没有lca
    }
}