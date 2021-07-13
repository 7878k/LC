// 95. Unique Binary Search Trees II
// Time & Space: O(4^n)
// 核心在bst左子树比root小，右子树比root大
class Solution {
    public List<TreeNode> generateTrees(int n) {
        // corer case
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);  // 递归入口 n的范围是1到n
    }
    
    // [lower, upper] 表示当前值的集合
    private List<TreeNode> helper(int lower, int upper) {
        List<TreeNode> ret = new ArrayList<>(); // 储存答案
        if (lower > upper) {                    // 当前二叉数为空， 返回空节点
            ret.add(null); 
        }
        
        for (int i = lower; i <= upper; i++) {
            List<TreeNode> leftList = helper(lower, i - 1);   // 所有左子树集合
            List<TreeNode> rightList = helper(i + 1, upper);  // 所有右子树集合
            
            // 从左子树集合选个左子树，从右子树集合选个右子树，然后拼到root上
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}