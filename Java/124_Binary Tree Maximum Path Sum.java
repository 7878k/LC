// 124. Binary Tree Maximum Path Sum
// Time & Space: O(N)
class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    // helper() 计算一个节点的最大贡献值，是一个直的path
    private int helper(TreeNode root) {
        if (root == null) return 0;
        // 如果有条path为负数，那么默认为0
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        // 最大值为root的值+左右的最大贡献值
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}