// 103. Binary Tree Zigzag Level Order Traversal
// 和LC102一样，只不过变成偶数行从左到右遍历，奇数行从右往左遍历
// 第一行是0
// TIME: O(N); SPACE: O(N)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        if (root == null) {
            return ret;
        }
        Boolean left = true; // 用于判断从左还是从右
        
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (left) {
                    level.offerLast(head.val);
                } else {
                    level.offerFirst(head.val);
                }
                
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            ret.add(new ArrayList(level));
            left = !left;
        }
        return ret;
    }
}