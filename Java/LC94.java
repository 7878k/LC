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

/**
如果右子树为空或者已经访问过了，然后访问根结点
否则，需要将该结点再次压回栈中，去访问其右子树，因为顺序是左-右-根
*/
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        
        TreeNode prev = null; // 记录前一个访问的节点
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // 一直到left子节点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            
            // 判断有没有right节点或者访问过没有
            if (root.right == null || root.right == prev) {
                ret.add(root.val);
                prev = root;
                root = null;
                // 右子树出栈的时候，每次出栈root不断上移，
                // 下一次循环时还会判断是否有右子树；
                // 如果不加prev就会陷入死循环~，加个prev做个判断，只有没有遍历过的右子树才能入栈
            } else { // 如果有right节点，就push root，然后visit right节点
                stack.push(root);
                root = root.right;
            }
        }
        return ret;
    }
}