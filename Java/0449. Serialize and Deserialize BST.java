// 449. Serialize and Deserialize BST
// 同LC297， 然是要用lower和upper来建Bst
// root左边比他小右边比他大
// TIME & SPACE: O(N)

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { // 去掉分隔符
            return "";
        }
        String s = String.valueOf(root.val); // 首先先建立root
        if (root.left != null) { 			 // 然后build左边右边
            s = s + "," + serialize(root.left);
        }
        if (root.right != null) {
            s = s + "," + serialize(root.right);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(Queue<String> queue, int lower, int upper) {
        if (queue.isEmpty()) { // 如果是空直接返回null
            return null;
        }
        String s = queue.peek();
        int val = Integer.parseInt(s);
		// 如果不在范围内返回null
        if (val < lower || val > upper) {
            return null;
        } else {
            queue.poll();
            TreeNode root = new TreeNode(val); // build root 
            root.left = helper(queue, lower, val);
            root.right = helper(queue, val, upper);
            return root;
        }   
    }
}
