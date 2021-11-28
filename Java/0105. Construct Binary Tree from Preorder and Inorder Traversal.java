// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Time & Space: O(n)
// SPEND: 25min

class Solution {
    int[] preorder;
    int[] inorder;
    int preorderIndex;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.inorderMap = new HashMap<>();

        int inorderIndex = 0;
        // map存中序遍历的val和对应位置
        for (int val: inorder) {
            inorderMap.put(val, inorderIndex++);
        }
        
        return helper(0, inorder.length - 1);
    }

    // 在前序遍历数组中，从前往后依次取到根节点，对应地去中序数组中确定左子树和右子树的范围
    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        // 前序遍历: root->left->right
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        // 中序遍历：left->root->right
        // 在中序遍历中定位根节点
        int rootIndex = inorderMap.get(root.val);
        // 左子树范围
        root.left = helper(left, rootIndex - 1);
        // 右子树范围
        root.right = helper(rootIndex + 1, right);
        return root;
    }
}