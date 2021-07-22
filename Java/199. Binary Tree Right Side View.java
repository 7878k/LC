// 199. Binary Tree Right Side View
// Time & Space: O(n)
// BFS and checking if current node is the last node of current level
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root= queue.poll();
                // 要拿到右边view的，就从左往右看，看最后一个
                if (root.left != null) {
                    queue.offer(root.left);
                }
                // 如果右子树为空，此时 看左子树最后一个
                if (root.right != null) {
                    queue.offer(root.right);
                }
                if (i == size - 1) {    // check if current node is the last one
                    ret.add(root.val);
                }
            }
        }
        return ret;
    }
}


/**
我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，
就可以保证每层都是最先访问最右边的节点的。
Time & Space: O(N)
 */
class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret, 0);
        return ret;
    }
    
    private void dfs(TreeNode root, List<Integer> ret, int depth) {
        if (root == null) {
            return;
        }
        // check if current depth = current level 
        if (depth == ret.size()) {
            ret.add(root.val);
        }
        depth++;
        dfs(root.right, ret, depth);
        dfs(root.left, ret, depth);
    }
}