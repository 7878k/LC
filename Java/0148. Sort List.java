// 148. Sort List
// Time: O(n logn), Space:O(1)
class Solution {
    // 自底向上归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        // 1. 首先从头向后遍历，算链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        
        // 2. 初始化，引入dummynode
        ListNode dummy = new ListNode(0, head);
        
        // 3. 每次将链表拆分成若干长度为subLen的子链表,
        // 并按照每两个子链表一组进行合并
        // subLen每次左移以为就是 subLen = subLen * 2
        for (int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next; // curr用于记录拆分链表的位置
            
            while (curr != null) {  // 如果链表没有拆完
                // 3.1 拆分subLen长度的链表1
                ListNode head1 = curr; // 第一个链表的头，就是curr的初始位置
                // 拆分subLen长度的链表1
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                
                // 3.2 拆分subLen长度的链表2
                ListNode head2 = curr.next; // 第二个链表的头，就是链表1的下一个
                curr.next = null;// 断开2个链表之间的链接
                curr = head2;
                // 拆分长度为subLen的链表2
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                
                // 3.3 再次断开第二个链表最后的next的链接
                ListNode next = null;
                if (curr != null) {
                    next = curr.next; // next用于记录拆分完两个链表的结束位置
                    curr.next = null; // 断开连接
                }
                
                // 3.4 合并两个subLen长度的有序链表
                ListNode merged = mergeTwoLists(head1, head2);
                prev.next = merged;         // prev.next 指向排好顺序的链表的头
                while (prev.next != null) { // 将prev移动到 subLen *2的欸之后去
                    prev = prev.next;
                }
                curr = next;                 // next用于记录拆分完2个链表的结束位置
            }
        }
        return dummy.next;
    }
    
    private ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if (p1 != null) {
            curr.next = p1;
        } else {
            curr.next = p2;
        }
        
        return dummy.next;
    }
}



class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        
        //split
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode second = slow.next;
        slow.next = null;
        
        ListNode newHead = sortList(head);
        ListNode secondHead = sortList(second);
        
        return merge(newHead, secondHead);
    }
    
    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode last = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                ListNode next = first.next;
                first.next = last.next;
                last.next = first;
                last = first;
                first = next;
            } else {
                ListNode next = second.next;
                second.next = last.next;
                last.next = second;
                last = second;
                second = next;
            }
        }
        
        if (first != null) {
            last.next = first;
        }
        
        if (second != null) {
            last.next = second;
        }
        return dummy.next;
    }
}