// 437. Path Sum III
// Time: O(N), Space: O(N)
class Solution {
    int target;
    // key是前缀和, value是大小为key的前缀和出现的次数
    Map<Integer, Integer> prefixMap = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        // 这是因为任何节点本身也可以形成一个路径（长度为1的路径）。
        // 如果某个节点的值就为target，那么它本身就是一个解。
        // 前缀和为0正好可以与它形成这个解。
        prefixMap.put(0, 1);
        return dfs(root, 0);
    }
    
    // 如果此前有和为curSum-target,而当前的和又为curSum,两者的差就肯定为target了
    private int dfs(TreeNode root, int curSum) {
        // base case
        if (root == null) {
            return 0;
        }
        // 当前的前缀和
        curSum += root.val;
        int result = 0;
        // 看看root到当前节点这条路上是否存在节点前缀和加target为curSum的路径
        result = prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);
        // 更新路径上当前节点前缀和的个数
        int left = dfs(root.left, curSum);
        int right = dfs(root.right, curSum);
        // 一个节点必须是另一个节点的祖先节点
        // 在回溯结束，回到本层时去除，保证其不影响其他分支的结果 
        // 如果左子树有个6， 右子树也有6，左子树的不能算进去要删掉
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);
        // 结果是当前节点前缀树的个数加上左边满足的个数加右边满足的个数
        return result + left + right; 
    }
}