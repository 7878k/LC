// 108. Convert Sorted Array to Binary Search Tree
// Time: O(n); Space: O(log(n))
//用binary search找中点，然后递归左边右边。

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        
        return root;
    }
}   
