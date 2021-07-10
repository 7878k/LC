/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 /**
 *	首先搞个dummy,然后dummy之后的list就是最后要返回的list了.
 *	来个ptr = dummy 用来遍历2个list
 *  遍历完了, l1或者l2往前移动, 然后ptr也要移动
 *	最后看l1或者l2还有没有剩下的 然后连上就行了
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        if (l1 != null)
            node.next = l1;
        else
            node.next = l2;
        return dummy.next;
    }
}