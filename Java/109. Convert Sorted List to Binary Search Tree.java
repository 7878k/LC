// 109. Convert Sorted List to Binary Search Tree
// Time: O(nlogn), Space: O(logn)
// 一共logn层递归，每次找中点是O（n/2) 所以是nlogn
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;  // 记录slow前面那个点
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow; 
        prev.next = null; // 断开中点之前的，之前的现在就变成左子树
        
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}