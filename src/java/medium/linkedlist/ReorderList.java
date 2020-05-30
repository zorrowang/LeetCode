package src.java.medium.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null) return;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode sec = slow.next;
        slow.next = null;
        fast = reverse(sec);
        slow = head;
        while (slow!=null && fast!=null) {
            ListNode node1 = slow.next, node2 = fast.next;
            slow.next = fast;
            fast.next = node1;
            slow = node1;
            fast = node2;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while(cur!=null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        head = pre;
        return head;
    }
}