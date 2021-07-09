// Because the input list is sorted, 
//we can determine if a node is a duplicate by
// comparing its value to the node after it in the list.
// Time O(n), space O(1)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val)
                node.next = node.next.next;
            else 
                node = node.next;
        }
        return head;
    }
}