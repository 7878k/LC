// 104. Maximum Depth of Binary Tree
// Time: O(n)
// Space: O(h)
// 找左边tree高度和右边高度，然后比较max + 1， 用recursion
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}