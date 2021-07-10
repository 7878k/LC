// 590. N-ary Tree Postorder Traversal
// TIME & SPACE: O(N)
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        traverse(root, ret);
        return ret;
    }
    
    private void traverse(Node root, List<Integer> ret) {
        for (Node node : root.children) {
            traverse(node, ret);
        }
        ret.add(root.val);
    }
}