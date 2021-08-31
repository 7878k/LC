// 1008. Construct Binary Search Tree from Preorder Traversal
// Time & Space O(n)
class Solution {
    int index = 0; // 遍历preorder array
    int length;    // array length
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        length = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE); // root可以为任意值
    }
    
    private TreeNode helper(int lower, int upper) {
        if (index == length) { // 所有的元素都已经添加到了二叉树中， 构造已完成
            return null;
        }
        int val = preorder[index];  // 获取当前元素的值
        if (val < lower || val > upper) {  // 如果不在范围内，就要回溯，去上一层
            return null;
        }                                   
        index++;                            // 如果在范围内， index++ 到array的下一个值
        TreeNode root = new TreeNode(val);  // 建一个节点， root.val是index++前的值
        root.left = helper(lower, val);     // recurse 左子树比自己小
        root.right = helper(val, upper);	// 右子树比自己大
        return root;
    }
}