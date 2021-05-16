// 257. Binary Tree Paths
// Time & Space O(n^2)

class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;
        helper(paths, root, "");
        return paths;
    }
    
    private void helper(List<String> paths, TreeNode root, String path) {
        if (root == null)
            return;
        
        path+=String.valueOf(root.val);
        
        // leaf node, return the while path
        if (root.left == null && root.right == null)
            paths.add(path);
        // left child
        else {
			helper(paths, root.left, path + "->");
            helper(paths, root.right, path + "->");
		} 
    }
}	