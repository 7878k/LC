// 1669. Merge In Between Linked Lists
// Time: O(N), Space: O(1)
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        for (int i = 0; i < a - 1; i++) {
            curr = curr.next;
        }
        ListNode left = curr;
        for (int i = 0; i < b - a + 1; i++) {
            curr = curr.next;
        }
        ListNode right = curr.next;
        left.next = list2;
        
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = right;
        return list1;
    }
}