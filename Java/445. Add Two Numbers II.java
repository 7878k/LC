// 445. Add Two Numbers II
// Time: O(max(m, n)); Space: O(m + n)
// 放到stack里，然后记录当前node和的值，下一个node和放在他的前面
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        int result = 0;
        int carry = 0;
        
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode prev = null;
        
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) +
                      (stack2.isEmpty() ? 0 : stack2.pop()) + carry;
            result = sum % 10;
            carry = sum / 10;
            
            ListNode curr = new ListNode(result);
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}