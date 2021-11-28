// 222. Count Complete Tree Nodes
// Time: O(log(n) * log(n))  getDepth = O(h), findNodes = O(h)
// Space: O(log(N))
// complete binary tree nodes: (2^h) - 1
// SPEND: 5min
class Solution {
    public int countNodes(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        // 1 << left = 2^left
        if (left == right) {
            // 如果相同，说明左子树肯定是满的，加上root 就是2^left，然后递归右子树
            return (1 << left) + countNodes(root.right);
        } else {
            // 如不相同，说明左子树更长，右子树肯定是满的，同上^^ 
            return (1 << right) + countNodes(root.left);
        }
    }
    
    // 计算数的高度
    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}


// solution 2
public int countNodes(TreeNode root) {
    if (root == null){
        return 0;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
}

