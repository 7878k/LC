// 237. Delete Node in a Linked List
// t & s: O(1)
// 替换node val位下一个的值，然后node连到下一个的下一个

// spend: 2min

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}