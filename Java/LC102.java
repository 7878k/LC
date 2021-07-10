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
            for (int i = 0; i < size; i++) { //一个loop代表一层，然后当前level存当前层所有node
                TreeNode head = queue.poll(); // 当前层的所有节点再上一个循环就放进来了
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


// BFS模板
void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
