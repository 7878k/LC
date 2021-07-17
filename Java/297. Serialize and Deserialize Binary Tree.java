// 297. Serialize and Deserialize Binary Tree
// TIME & SPACE: O(N)
// 用BFS建树 走preorder, 先root再left再right
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { // #代表这个位置是空的
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right); // recursion
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
		// 先把string每个字符用 ， 分隔开，然后把他们放到一个list里
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    
    private TreeNode helper(Queue<String> queue) {
		// preorder 首先看root， 如果root是空就null
        String string = queue.poll();
        if (string.equals("#")) {
            return null;
        } else { // 如果root不是空，就开始建树，然后recurse left and right
            TreeNode root = new TreeNode(Integer.valueOf(string));
            root.left = helper(queue);
            root.right = helper(queue);
            return root;
        }

        
    }
}
