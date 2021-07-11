// 144. Binary Tree Preorder Traversal
// Time: O(N); Space: O(log(n))-average, O(n)- worst case
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }
    
    private void preOrder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}

// iterative 
// Time: O(N), Space: O(N)
// DFS Preorder: root->left->right 所以先把root放答案，然后利用stack的LIFO，把right
// 先放stack，然后再放left，这样是left先出来
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }  
        while (!stack.empty()) {
            root = stack.pop();
            ret.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return ret;
    }
}