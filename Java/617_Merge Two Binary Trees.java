// 617. Merge Two Binary Trees
// Time: O(m), Space:O(m), 
// m为两个树中更少的节点数，因为只有都不为空的时候
// 才会进行合并操作，所以最大的操作数不会超过m， 递归的层数也不会超过m
class Solution {
    // 三种情况
    // 1: 其中一个是null，就返回另一个
    // 2：都不是null，就新建node，值为两个相加
    // 3：都是null情况同1
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 先合并一个节点，然后再分别合并左子树和右子树
        TreeNode newTree = new TreeNode(root1.val + root2.val);
        newTree.left = mergeTrees(root1.left, root2.left);
        newTree.right = mergeTrees(root1.right, root2.right);
        return newTree;
    }
}