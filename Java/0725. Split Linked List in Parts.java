// 725. Split Linked List in Parts
// Time: O(N + k); Space: O(k)
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        // 统计链表的结点个数
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        
        // 计算每部分至少需要分配多少个结点
        int size = count / k;
        // 计算总共剩余的结点数。从第0部分开始，
        // 每部分从rest中取1个，与base加起来，直至rest减为0
        int addition = count % k;
        
        cur = head;
        ListNode[] ret = new ListNode[k];
        
        for (int i = 0; i < k && cur != null; i++) {
            ret[i] = cur;
            int plus = i < addition ? 1 : 0;
            int length = size + plus;
            
            for (int j = 0; j < length - 1; j++) {
                cur = cur.next;
            }
            
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        return ret;
    }
}