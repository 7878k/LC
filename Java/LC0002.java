// 2. Add Two Numbers
// Time: O (max(m,n)); Space: O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        int result = 0;
        int carry = 0;
        // 双指针， 进位carry = sum / 10; 结果ret = sum % 10
        while (l1 != null || l2 != null || carry > 0) {
            // 如果node == null， 就把他当作0
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            result = sum % 10;
            head.next = new ListNode(result);
            head = head.next;
            // 如果不是null，就move to next node
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        return dummy.next;
    }
}