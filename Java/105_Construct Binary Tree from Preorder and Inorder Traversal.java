// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Time: O(n), Space: O(n)
// 同LC106
class Solution {
    int[] preorder;
    int[] inorder;
    int preOrderIndex = 0;
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (Integer val : inorder) 
            inOrderMap.put(val, index++);
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);
        int rootIndex = inOrderMap.get(root.val);
        root.left = helper(left, rootIndex - 1);
        root.right = helper(rootIndex + 1, right);
        return root;
    }
}