// 94. Binary Tree Inorder Traversal
// time: O(n), space: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret);
        return ret;
    }
    
    private void traverse(TreeNode root, List<Integer> ret) {
        if (root == null)
            return;
        
        traverse(root.left, ret);
        ret.add(root.val);
        traverse(root.right, ret);
    }
}

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        TreeNode node = root;
        
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            ret.add(node.val);
            node = node.right;
        }
        return ret;
    }
}