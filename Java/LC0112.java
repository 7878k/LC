// 112. Path Sum
// T: O(n), S: O(h)
// base case, when root is leaf node, check if root.val == targetSum, cause it's the last number to sum up
// use targetSum - curr val, if the left/right root val = targetSum, then its a valid path

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
		// base case 1:
        if (root == null)
            return false;
        // base case 2: 当到达子节点的时候，检测当前值是不是等于targetSum
        if (root.left == null && root.right == null)
            return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}