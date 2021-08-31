// 83. Remove Duplicates from Sorted List
// Because the input list is sorted, 
// we can determine if a node is a duplicate by
// comparing its value to the node after it in the list.
// Time O(n), space O(1)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head; // 如果要修改头节点，就要用dummy node， 这个保留一个node，所以不动头节点
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}