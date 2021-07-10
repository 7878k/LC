// 107. Binary Tree Level Order Traversal II
// TIME: O(N); SPACE: O(N)
// 和LC102一样，只不过最后加入ret的时候 反过来加
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        if (root == null) {
            return ret;
        }
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            ret.add(0,level); // 加到index 0的位置，每次都这样，就每次在最前面加
        }
        return ret;
    }
}