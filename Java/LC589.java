// 589. N-ary Tree Preorder Traversal
// TIME & SPACE: O(N)
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        traverse(root, ret);
        return ret;
    }
    
    private void traverse(Node root, List<Integer> ret) {
        ret.add(root.val);
        for (Node node : root.children) {
            traverse(node, ret);
        }
    }
}