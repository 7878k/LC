// 145. Binary Tree Postorder Traversal
/**
如果右子树为空或者已经访问过了，然后访问根结点
否则，需要将该结点再次压回栈中，去访问其右子树，因为顺序是左-右-根
*/
// TIME & SPACE: O(N)
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        
        TreeNode prev = null; // 记录前一个访问的节点
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // 一直到left子节点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            
            // 判断有没有right节点，或者right节点访问过没有
			// 如果不判断，当回到根节点后，又会判断有没有right节点
            if (root.right == null || root.right == prev) {
				// 没有右子树，也有左子树，才会加入ret
                ret.add(root.val);
                prev = root;
                root = null;
                // 右子树出栈的时候，每次出栈root不断上移，
                // 下一次循环时还会判断是否有右子树；
                // 如果不加prev就会陷入死循环~，加个prev做个判断，只有没有遍历过的右子树才能入栈
            } else { // 如果有right节点，就push root，然后visit right节点
                stack.push(root);   // 这个是右节点的根节点，进栈，到下一层循环的时候，root已经变成右节点
                root = root.right; 	// 右节点会在while (root != null)里被放进stack，
									// 此时stack里有右节点，然后才是根节点。
            }
        }
        return ret;
    }
}


class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            ret.add(0, root.val); // 每次放放在开头的位置，这样头节点肯定在ret的最后
            if (root.left != null) {  // left先进stack，就后访问
                stack.push(root.left);
            }
            if (root.right != null) { // right先进，先访问，但是val每次是放在ret的第一个位置
									  // 所以right放了后，left再放在第一个位置，所以顺序还是left - right - root
                stack.push(root.right);
            }
        }
        return ret;
    }
}