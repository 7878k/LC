// 206. Reverse Linked List
// Time O(n)
// Space O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        // if empty list or at end of the list (head.next == null), now return head;
        if (head == null || head.next == null)
            return head;
        // reverse every node except the first one, return newHead when base case meets
        ListNode newHead = reverseList(head.next); 
        // now we only have one node to reverse node1 -> node2 become node2 -> node1
        head.next.next = head;
        head.next = null;
        return newHead; // newHead is the last node 
    }
}

// Time O(n)
// Space O(1)
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;           // store prev node
        while (head != null) {          // reverse every node
            ListNode next = head.next;  // store next node
            head.next = prev;           // reverse first node
            prev = head;                // move prev to current head
            head = next;           		// head move to next node to reverse
        }
        return prev;                    // now head is null, so return prev
    }
}
