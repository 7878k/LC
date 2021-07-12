// 257. Binary Tree Paths
// Time: O(N^2), 每个节点会被访问一次，然后path每次都会被复制一次，所以是N*N
// Space: O(N^2) 如果是每个节点只有一个子节点，那么递归层数就是N， 然后path也会有代价是N，所以是N^2
// bfs到leaf node，然后添加这条path到答案； 如果不是leaf node，继续recursion left 和 right
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        helper(root, "", ret);
        return ret;
    }
    
    private void helper(TreeNode root, String path, List<String> ret) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val)); //当前path放入第一个数，就是root; Integer.toString()可以把数字转为string
            
            if (root.left == null && root.right == null) { // 如果当前节点是叶子节点，那么就把当前path加到答案里
                ret.add(pathSB.toString()); 
            } else { // 当前不是叶子节点，加个-> 然后遍历左右节点
                pathSB.append("->");
                helper(root.left, pathSB.toString(), ret);
                helper(root.right, pathSB.toString(), ret);
            }
        }
    }
}