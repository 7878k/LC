// 543. Diameter of Binary Tree
// The diameter of a binary tree is the length of the longest path 
// between any two nodes in a tree. This path may or may not pass through the root.
// 需要存一个max用来比较每次找到的left + right
// Time: O(n)
// Space: O(h)

class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}