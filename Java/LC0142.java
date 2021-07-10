// 142. Linked List Cycle II
// Share Given a linked list, return the node where the cycle begins. 
// If there is no cycle, return null.
// Time: O(N), Space: O(1)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 用快慢指针， 慢指针走到cycle起点的距离等于head到cycle起点的距离
/** a是head到起点的距离，b是快慢相遇的距离，c是剩下cycle的距离
slow * 2 = fast;
slow = a + b;
fast = a + b + c + b = a + 2*b + c;
(a + b)*2 = a + 2*b + c;
a = c;
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {  // 先判断是不是cycle
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ptr = head;
        while (ptr != slow.next) { // 因为fast = head.next 所以slow之后也要进一步
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;

    }
}