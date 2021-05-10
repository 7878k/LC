// FIND MID AND REVERSE MID.NEXT
// COMPARE FROM HEAD(P1) AND MID.NEXT(P2), IF P2 IS NULL MEANS TRUE, OTHERHISE FALSE

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        
        ListNode mid = getMid(head);
        mid.next = reverse(mid.next);
        ListNode p1 = head;
        ListNode p2 = mid.next;
        
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }
    
    
    private ListNode getMid(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}