// 94. Binary Tree Inorder Traversal
// time: O(n), space: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret);
        return ret;
    }
    
    private void traverse(TreeNode root, List<Integer> ret) {
        if (root == null)
            return;
        
        traverse(root.left, ret);
        ret.add(root.val);
        traverse(root.right, ret);
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root == null) {
            return ret;
        }
		
        TreeNode node = root;

		//root为空且stack为空，遍历结束
        while (!stack.isEmpty() || node != null) {
			// 先遍历所有left children
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
			
			// 此时root==null，说明上一步的root没有左子树
            // 1. 执行左出栈。因为此时root==null，导致root.right一定为null，进入下一层while
            // 2. 此时root为null，直接pop一个， 就是上一个节点的跟，根出栈，加入ret。此时root.right可能存在
            // 3a. 若root.right存在，右入栈，再出栈
            // 3b. 若root.right不存在，重复步骤2
            // 左子树根节点
			// inorder 是左-根-右
            node = stack.pop();
			// 弹出来加入答案
            ret.add(node.val);
			// 如果有右节点，就加入stack； 这个右节点的root再上一轮就弹出了
            node = node.right;
        }
        return ret;
    }
}