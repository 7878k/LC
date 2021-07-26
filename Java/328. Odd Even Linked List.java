// 328. Odd Even Linked List
// Time: O(n); Space: O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        
        // 对于奇数长度链表，当even == null时结束循环，
        // 对于偶数长度链表，当even.next == null时结束循环
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    } 
}