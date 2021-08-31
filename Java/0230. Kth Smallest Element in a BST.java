// 230. Kth Smallest Element in a BST
// Time: O(N), Space: O(1)
// inorder traversal in bst
class Solution {
    private int ans;
    private int num;
    
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
    
    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        num++;
        if (num == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }
}