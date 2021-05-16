// 160. Intersection of Two Linked Lists
// use hashset
// time o(n+m), space o(m)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesB = new HashSet<>();
        
        while (headB != null) {
            nodesB.add(headB);
            headB = headB.next;
        }
        
        while (headA != null) {
            if (nodesB.contains(headA))
                return headA;
            headA = headA.next;
        }
        return null;
    }
}

// method 2
// time o(n+m), space o(1)
/* A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。 
如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点
 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}