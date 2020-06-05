package src.java.easy.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
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