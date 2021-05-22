// 112. Path Sum
// T: O(n), S: O(h)
// base case, when root is leaf node, check if root.val == targetSum, cause it's the last number to sum up
// use targetSum - curr val, if the left/right root val = targetSum, then its a valid path

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        
        if (root.left == null && root.right == null)
            return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}