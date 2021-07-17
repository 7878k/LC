// 662. Maximum Width of Binary Tree
// Time: O(N); Space:O(n)
/**
 *       0
       /   \
      0     1
     / \     \  
    0   1     3 
*/
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 1;  // one node = 1 width
        // use linkedlist to peekFirst()/peekLast()
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // check max width for last level
            max = Math.max(max, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    // root.left.val = root.val * 2
                    root.left.val = root.val * 2;
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    // root.right.val = root.val * 2 + 1
                    root.right.val = root.val * 2 + 1;
                    queue.offer(root.right);
                }
            }
        }
        return max;
    }
}