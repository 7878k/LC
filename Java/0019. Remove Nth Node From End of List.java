// 19. Remove Nth Node From End of List
// Time: O(n), Space: O(1)
// 双指针fast先走n，然后当fast和slow开始同步走，
// 当fast走完的时候，slow就在倒数第n的前节点，因为slow的起点是dummy，所以少走一步
// 最后返回dummy.next
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 因为开始slow是dummy，所以当fast走完的时候，slow是target node的prev node
        slow.next = slow.next.next;
        return dummy.next;
    }
}