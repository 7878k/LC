// 25. Reverse Nodes in k-Group
// Time: O(n); Space: O(1)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode end = dummy;
        
        while (end.next != null) {
            for (int i = 0; i < k && end != null ; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            
            start.next = next;
            pre = start;
            end = start;
        }
        
        return dummy.next;
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