// 1372. Longest ZigZag Path in a Binary Tree
// Time: O(N), Space: O(h)
// isLeft代表前一个点走的是left还是right
// 传入boolean isLeft, 如果之left，那么就要加right的值+1
// 反之就是left + 1， 1是你传到下一个点是已经走了1个长度为1的path
// 这样保证加的值是zig zag，left肯定和right匹配
class Solution {
    int LongestPath = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true); // root node没有parent 所以默认是true
        return LongestPath;
    }
    
    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, true);
        int right = dfs(root.right, false);
        LongestPath = Math.max(LongestPath, Math.max(left, right));
        return isLeft ? right + 1 : left + 1;
    }
}