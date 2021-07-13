// 450. Delete Node in a BST
// Time: O(logN); Space: O(H)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)  // base case
            return null;
        if (root.val > key) // 如果root比key大，那么往左走
            root.left = deleteNode(root.left, key);
        else if (root.val < key)    // 反之往左走
            root.right = deleteNode(root.right, key);
        else if (root.left == null) // 如果找到那个值，但是他只有右边，就返回root.right
            return root.right;
        else if (root.right == null)
            return root.left;       // 反之返回root.left
        else {
            root.val = findMin(root.right); // 如果左右都有，找右子树最小值（predecessor），替换掉
            root.right = deleteNode(root.right, root.val); // 删除右子树最小值
        }
        return root;
    }
    
    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}