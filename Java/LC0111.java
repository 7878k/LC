// use recursion to traverse left and right
// if left or right tree is empty, then the depth is on the other side
// finally add 1 (root) to the length
// Time O(n), space O(n)

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        // 如果有一边的子树都是null, 那就是糖葫芦，那么最小depth就不是0，是唯一的那一边
        // 这种情况left right都相加，反正其中一个是0，不影响答案
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        
        return Math.min(left, right) +1;
    }
}