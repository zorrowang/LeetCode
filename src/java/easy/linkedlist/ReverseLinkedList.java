package src.java.easy.linkedlist;

public class ReverseLinkedList {
    // Rewritten on 2021/01/23
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null)  return head;
        ListNode prev = head, cur = head.next;
        prev.next = null;
        while (cur != null) {
            ListNode n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head==null) return head;
        ListNode pre = null;
        while(head.next!=null) {
            ListNode node = head.next;
            head.next = pre;
            pre = head;
            head = node;
        }
        head.next = pre;
        return head;
    }
}