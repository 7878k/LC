// 102. Binary Tree Level Order Traversal
// Time: O(n), Space: O(1)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>(); // 最后结果
        Queue<TreeNode> queue = new LinkedList<>();	 // 每一层的node都放在queue
        queue.offer(root);
        
        if (root == null) {
            return ret;
        } 
        
        while (!queue.isEmpty()) {
			// 用level记录当前层的所有节点
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            ret.add(level);
        }
        return ret;
    }
}