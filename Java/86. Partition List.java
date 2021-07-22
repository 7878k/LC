// 86. Partition List
// Time: O(N), Space: O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        ListNode left = dummyLeft;
        ListNode right = dummyRight;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val < x) {
                left.next = curr;
                left = left.next;
            } else {
                right.next = curr;
                right = right.next;
            }
            curr = curr.next;
        }
        
        left.next = dummyRight.next;
        right.next = null; // 原来的right.next 可能指向一个小于x的节点
                           // 这是因为当前节点复用的是原链表的节点
        return dummyLeft.next;
    }
}