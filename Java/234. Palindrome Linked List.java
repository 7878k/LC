// 234. Palindrome Linked List
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



class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;
        ListNode mid = findMid(head);
        mid = reverse(mid);
        ListNode p1 = head;
        ListNode p2 = mid;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }
    
    private ListNode findMid(ListNode head) {
        if (head == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        
		// 找中点， 这不是cycle的，所以fast停的时候，就是mid左边的那个
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}