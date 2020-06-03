package src.java.medium.linkedlist;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)   return null;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head.next, pre = head;
        while (cur != null) {
            ListNode node = dummy.next, preNew = dummy;
            while(node.val < cur.val) {
                preNew = node;
                node = node.next;
            }
            ListNode n = cur;
            if (node != cur) {
                cur = cur.next;
                n.next = node;
                preNew.next = n;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = null;
        return dummy.next;
    }
}