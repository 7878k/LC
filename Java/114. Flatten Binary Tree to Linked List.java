// 114. Flatten Binary Tree to Linked List 
/**
首先将根节点的左子树变成链表
其次将根节点的右子树变成链表
最后将变成链表的右子树放在变成链表的左子树的最右边
 */
// Time & Space: O(N)
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
}


// Time: O(N), Space: O(1)
// 找到当前节点前驱节点，然后把右子树接在它的右边
// 然后断掉当前节点右子树，把当前节点和之前拼接的树连在一起
// 然后移动移动当前节点到下一个，直到是叶子节点
class Solution2 {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            // 如果不为空，找前驱节点
            if (curr.left != null) {
                // next是要和当前节点右边拼在一起的
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                // 找前驱节点
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                // preorder顺序
                predecessor.right = curr.right;
                curr.left = null;   // 断开
                curr.right = next;  // 拼在一起
            }
            curr = curr.right;
        }
    }
}