// use recursion to traverse left and right
// if left or right tree is empty, then the depth is on the other side
// finally add 1 (root) to the length
// Time O(n), space O(n)

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        
        if (leftHeight == 0 || rightHeight == 0)
            return leftHeight + rightHeight + 1;
        
        return Math.min(leftHeight, rightHeight) + 1;
    }
}