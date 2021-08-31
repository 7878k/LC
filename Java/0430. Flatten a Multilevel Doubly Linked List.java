// 430. Flatten a Multilevel Doubly Linked List
// Time & Space: O(N)
// preorder traverse,  顺时针旋转90°
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        // pseudo head to ensure the prev pointer is never none
        Node dummy = new Node(0, null, head, null);
        flattenDFS(dummy, head);
        
        // detach the pseudo head from the real head
        dummy.next.prev = null;
        return dummy.next;
    }
    
    // return the tail of the flatten list 
    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        
        prev.next = curr;
        curr.prev = prev;
        
        // curr.next might be altered during the recursion 
        Node tempNext = curr.next;
        
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;  // child is not needed after recursion 

        return flattenDFS(tail, tempNext);
    }
}