// 889. Construct Binary Tree from Preorder and Postorder Traversal
// TIME & SPACE: O(N)
// PRE的左子树的第一个node是post左子树的最后一个node，
// 得到左子树第一个node坐标，和post的第一个坐标，就得到了左子树的范围，
// 右子树的范围跟左子树一样， post的最后一个坐标是root，所以右子树的 right坐标 -1 就得到了右子树的范围

class Solution {
    int[] pre;
    int[] post;
    int preIndex = 0;
    Map<Integer, Integer> postOrderMap = new HashMap<>();
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        int index = 0;
        for (Integer val : post) 
            postOrderMap.put(val, index++);
        return helper(0, post.length - 1);
    }
    
    private TreeNode helper(int postLeft, int postRight) {
		// base case 当没有node的时候： 1， left > right； 2， preIndex已经走完了所有node
        if (postLeft > postRight || preIndex >= pre.length) 
            return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
		// base case 2 当preIndex == length的时候，因为之前有preIndex++ 说明最后一个点都visit了，直接return
		// 如果只剩一个node 就是left == right
        if (preIndex == post.length || postLeft == postRight)
            return root;
        int postIndex = postOrderMap.get(pre[preIndex]); // 得到post array里的左子树最后一个节点
        root.left = helper(postLeft, postIndex); // postLeft 是post array里左子树第一个点
        root.right = helper(postIndex + 1, postRight - 1); // right - 1是因为post最后一个点是root
        return root;
    }
}