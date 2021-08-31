// 129. Sum Root to Leaf Numbers
// Time & Space: O(N)
// sum = sum of left + sum of right
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        // current val = prev * 10 + current val
        int sum = preSum * 10 + root.val;
        // if leaf node, return sum
        if (root.left == null && root.right == null) {
            return sum;
        } else { // else recurse left / right
            int left = helper(root.left, sum);
            int right = helper(root.right, sum);
            return left + right;
        }
        
    }
}