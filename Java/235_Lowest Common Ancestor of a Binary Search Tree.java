// 235. Lowest Common Ancestor of a Binary Search Tree
// Time & Space: O(N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
			// 如果都比root小，肯定在root左边
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
			// 如果都比root大，肯定在root右边
            return lowestCommonAncestor(root.right, p, q);
        }
		// 如果root在两个值中间，就是答案
        return root;
    }
}