// 173. Binary Search Tree Iterator
// Time: 均摊O(1), Space:O(n)
// inorder traversal
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        pushAllLeft(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}


// Time: O(1), Space: O(n)
class BSTIterator2 {
    Deque<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        cur = root;
    }
    
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }
}