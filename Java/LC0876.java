// 快慢指针，快的走两步， 慢的一步，最后slow就是中点
// time:O(n), space: o(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
}