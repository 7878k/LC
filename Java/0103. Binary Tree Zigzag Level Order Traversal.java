// 103. Binary Tree Zigzag Level Order Traversal
// 和LC102一样，只不过变成偶数行从左到右遍历，奇数行从右往左遍历
// 第一行是0
// TIME: O(N); SPACE: O(N)

// new 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            
            while (!queue.isEmpty()) {
                int size = queue.size();
                Deque<Integer> level = new ArrayDeque<>();
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    if ((ans.size() & 1) == 0) {
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
                ans.add(new ArrayList<>(level));
            }
        }
        return ans;
    }
}


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
            left = !left;  // 记得neg left
        }
        return ret;
    }
}


class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (ret.size() % 2 == 0) { // 用ret的size来判断奇偶
                    level.add(root.val);
                } else {
                    level.add(0, root.val);
                }
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            ret.add(level);

        }
        return ret;
    }
}