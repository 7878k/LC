// 617. Merge Two Binary Trees
// T & Space O(m), m is not min nodes of two trees
// 1, if not null for both, add value together
// 2, if null for either one, return the otehr
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }