// 226. Invert Binary Tree
// Time & Space: O(n)
// reverse left & right, then make reverse root.left and root.right

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        
		// 有一个magic可以把left和right字数的所有子节点都反转
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
		// 这个时候root的left和right都已经反转了，剩下就是把root的left和right调转位置
        root.left = right;
        root.right = left;
        
        return root;
        
    }
}