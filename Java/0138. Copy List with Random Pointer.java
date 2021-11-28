// 138. Copy List with Random Pointer
// Time: O(n), Space: O(1)
// SPEND: 20min
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node curr = head;
        //第一步，在每个原节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        curr = head;
        //第二步，设置新节点的随机节点
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        Node dummy = new Node(-1);
        Node newHead = dummy;
        curr = head;

        //第三步，将两个链表分离
        while (curr != null) {
            newHead.next = curr.next;
            newHead = newHead.next;
            curr.next = newHead.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}


// Time & Space: O(n)
class Solution2 {
    Map<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!nodeMap.containsKey(head)) {
            Node newNode = new Node(head.val);
            nodeMap.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return nodeMap.get(head);
    }
}