// 116. Populating Next Right Pointers in Each Node
//  递归先连 左右，然后连上中间的。


// Time: O(N), Space: O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        // 横着看的，所以先判断左子树
        while (pre.left != null) {
            // curr是当前level的当前节点
            Node curr = pre;
            while (curr != null) {
                // 首先把root的左右子树给连接
                curr.left.next = curr.right;
                // 如果上一层全部连在一起了
                if (curr.next != null) {
                    // 就把这一层的不同root的子树连在一起
                    curr.right.next = curr.next.left;
                }
                curr = curr.next; // 当前curr到下一个
            }
            pre = pre.left;       // 到下一层
        }
        return root;
    }
}

// Time: O(N), Space: O(h)
class Solution2 {
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