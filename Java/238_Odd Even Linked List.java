// 328. Odd Even Linked List
// Time: O(N), Space: O(1)
// 双指针，一个指向odd，一个指向even 
// head是odd，head.next是even
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next; // even head就是head.next 
        ListNode odd = head;
        ListNode even = evenHead;

		// 对于奇数长度链表，当even == null时结束循环，对于偶数长度链表，当even.next == null时结束循环
        while (even != null && even.next != null) {
            // odd的下一个是even的下一个
            odd.next = even.next;
            // 然后移动odd指针
            odd = odd.next;
            // vice versa
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;    // 最后连接两个节点
        return head;
    }
}