// 110. Balanced Binary Tree
// T & S : O(n)
// use -1 to denote the tree is npt balanced/
// >=0 value means the tree is balanced and it is the height of the tree

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        return height(root) != -1;
    }
    
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        // if left or right is already not balanced, no need to congtinue 
        int left = height(root.left);
        if (left == -1)
            return -1;
        
        int right = height(root.right);
        if (right == -1)
            return -1;
        // if not balanced return -1
        if (Math.abs(left - right) > 1)
            return -1;
        
        return Math.max(left ,right) + 1;
    }
}