// 1382. Balance a Binary Search Tree
// Time & Space: O(N)
// LC108的套娃题， traverse一遍放进list，然后和LC108一样
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret);
        return buildTree(0, ret.size() - 1, ret);
    }
    
    private void traverse(TreeNode root, List<Integer> ret) {
        if (root == null) return;
        traverse(root.left, ret);
        ret.add(root.val);
        traverse(root.right, ret);
    }
    
    private TreeNode buildTree(int left, int right, List<Integer> ret) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(ret.get(mid));
        root.left = buildTree(left, mid - 1, ret);
        root.right = buildTree(mid + 1, right, ret);
        return root;
    }
}