package src.java.easy.linkedlist;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode cur = head, pre = head;
        while (cur != null) {
            cur = cur.next;
            if (cur == null)    break;
            if (cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
        }
        return head;
    }
}