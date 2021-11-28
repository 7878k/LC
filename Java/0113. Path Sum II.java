// 113. Path Sum II
// Time: O(N^2), copy: O(N), traverse:O(N)
// Space: O(N)
// SPEND: 10min
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, targetSum, ret, new ArrayList<>());
        return ret;
    }
    
    private void dfs(TreeNode root, int targetSum, List<List<Integer>> ret, List<Integer> path) {
        if (root == null) {
            return; 
        }
        // add current to path
        path.add(root.val);
        // if it's a leaf node and the val is targetSum, add result
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ret.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);   // backtrack
            return;
        }
        // if not leaf node, continue to find left and right 
        dfs(root.left, targetSum - root.val, ret, path);
        dfs(root.right, targetSum - root.val, ret, path);
        // if current root has been used after recursion, delete it
        path.remove(path.size() - 1);
    }
}

 class Solution2 {
   public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> tmp = new ArrayList<>();
       dfsSum(root, sum, tmp, res);
       return res;
   }
   public void dfsSum(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
       if (root == null) {
          return;
       }
       tmp.add(root.val);
       if (root.left == null && root.right == null && root.val == sum) {
          res.add(new ArrayList(tmp));
       }

       dfsSum(root.left, sum - root.val, tmp, res);
       dfsSum(root.right, sum - root.val, tmp, res);
       tmp.remove(tmp.size() - 1);
   }
}