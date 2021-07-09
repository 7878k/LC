// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Time: O(n), Space: O(n)
class Solution {
        int postIndex;
        int[] postOrder;
        int[] inOrder;
        Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrder = postorder;
        inOrder = inorder;
        
        // 后序遍历的最后一个元素就是根节点
        postIndex = postorder.length - 1;
        
        // 建立一个map， key是元素，value是下标
        int index = 0;
        for (Integer val : inOrder) {
            indexMap.put(val, index++);
        }
        
        // 表示当前递归到中序序列中当前子树的左右边界
        return helper(0, inOrder.length - 1); // 递归函数 helper(left, right) 
    }
    
    public TreeNode helper(int left, int right) {
        // base case
        if (left > right) {
            return null;
        }
        
        // root的位置就是post array里的最后一个数
        int rootVal = postOrder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        
        // 中序列表中root的左右分别是左右子树
        int index = indexMap.get(rootVal);
        postIndex--; // 减一是因为下一轮recursion要找另一个root
        
        // 后序遍历是先左后右， 反过来的时候就要先右后左
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        
        return root;
        
    }
}