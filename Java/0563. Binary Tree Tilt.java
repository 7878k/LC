// 563. Binary Tree Tilt
// Time & Space: O(n)
// SPEND: 7min

class Solution {
    int ans = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = helper(root.left);
        int sumRight = helper(root.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + root.val;
    }
}