// 257. Binary Tree Paths
// Time & Space O(n^2) n个nodes 每次复制n	
// BFS 遍历， 如果是leaf，直接加这条path到result里；如果不是就bfs到底，然后每一次都:path + -> + value

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;

        helper(root, String.valueOf(root.val), result);
        return result;
    }
    
    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
            
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}