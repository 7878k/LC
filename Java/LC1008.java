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
        if (index == length) { // array走完说明所有元素都加入bst
            return null;
        }
        int val = preorder[index];  // 获取当前元素的值
        if (val < lower || val > upper) {  // 如果不在范围内，就说明是null
            return null;
        }                                   // 不在范围内，就会回溯，一直到范围内，
        index++;                            // 如果在范围内， index++ 到array的下一个值
        TreeNode root = new TreeNode(val);  // 建一个节点
        root.left = helper(lower, val);     // recurse 
        root.right = helper(val, upper);
        return root;
    }
}