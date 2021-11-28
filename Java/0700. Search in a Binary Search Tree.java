// 700. Search in a Binary Search Tree
//Time & Space: O(n)
// SPEND: 10min
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(root.val < val ? root.right : root.left, val);
    }
}

// Time: O(n); Space: O(1)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }
}