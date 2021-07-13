// 99. Recover Binary Search Tree
// Time: O(n), Space: O(h)
// iterative 
class Solution {
	// inorder 遍历里面数是递增的
	// 如果bst里面两个node换了位置，那么这里面就有2个错的数
	// 先找到第一个错的数，这个数的下一个肯定比它小
	// 继续找第二个数，这个数肯定比之前的小
    public void recoverTree(TreeNode root) {
        TreeNode first = null;  // 第一个错的数		
        TreeNode second = null; // 第二个错的数
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        Stack<TreeNode> stack = new Stack<>();
        
		// inorder iterative traverse
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
			// 如果发现错的数，first 为prev
            if (root.val < prev.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else { // 要继续找第二个错的数
                    second = root;
                }
            }
            prev = root; // prev每次移动到下一个，就是root
            root = root.right;
        }
		// 替换位置
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}


// recursion 
class Solution {
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        traverse(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (root.val < prev.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;
        traverse(root.right);
    }
}