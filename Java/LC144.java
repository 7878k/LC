// 144. Binary Tree Preorder Traversal
// Time: O(N); Space: O(log(n))-average, O(n)- worst case
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }
    
    private void preOrder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}