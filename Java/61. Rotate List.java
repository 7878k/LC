// 61. Rotate List
// Time: O(N); Space: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // k为0的时候也要返回原链表
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int n = 1; // n就是length
        ListNode curr = head;
        while (curr.next != null) {
            n++;
            curr = curr.next; // 现在curr在原来链表最后一个节点
        }
        
        // n - k % n 就是新链表在原列表的最后一个位置
        int add = n - k % n; // 算新链表的最后一个节点在哪
        if (add == n) {  // 说明没有移动
            return head;
        }
        // 查了需不需要移动后 再构成环
        curr.next = head;     // 连成一个环
        
        
        while (add > 0) {
            curr = curr.next; 
            add--;
        }
        // 现在curr在是新链表的最后一个位置， 头就是它的下一个，因为是个环
        ListNode ret = curr.next;
        curr.next = null;
        
        return ret;
    }
}