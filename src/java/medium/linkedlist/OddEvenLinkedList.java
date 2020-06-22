package src.java.medium.linkedlist;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)   return head;
        int cnt = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            cnt++;
        }
        if (cnt <= 2)   return head;
        ListNode tail = cur;
        cnt = cnt / 2;
        cur = head.next;
        ListNode pre = head;
        while (cnt > 0) {
            pre.next = pre.next.next;
            tail.next = cur;
            tail = tail.next;
            tail.next = null;
            cur = pre.next.next;
            pre = pre.next;
            cnt--;
        }
        return head;
    }
}