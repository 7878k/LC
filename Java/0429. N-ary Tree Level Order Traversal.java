// 429. N-ary Tree Level Order Traversal
// Time & Space: O(n)
// BFS

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                path.add(node.val);
                queue.addAll(node.children);
            }
            ans.add(path);
        }
        return ans;
    }
}