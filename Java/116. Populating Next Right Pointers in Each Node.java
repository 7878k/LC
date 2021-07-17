// 116. Populating Next Right Pointers in Each Node
//  递归先连 左右，然后连上中间的。


class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        helper(root.left, root.right);
        return root;
    }
    
    private void helper(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return;
        
        root1.next = root2;
        
        helper(root1.left, root1.right);
        helper(root2.left, root2.right);
        helper(root1.right, root2.left);
    }
}