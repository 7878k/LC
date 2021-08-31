// 92. Reverse Linked List II
// Time: O(N), Space:O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);    
        ListNode pre = dummy;
        
        // pre是left前一个node
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        // 下一个节点到right的位置
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        
        // 得到需要反转的node
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        
        // 截断
        pre.next = null;
        rightNode.next = null;
        
        reverse(leftNode);
        
        // 把断的跟原来的连在一起
        pre.next = rightNode;
        leftNode.next = cur;
        
        return dummy.next;
    }
    // reverse
    private void reverse(ListNode root) {
        ListNode prev = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
    }
}