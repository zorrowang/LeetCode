package src.java.medium.linkedlist;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)  return head;
        
        ListNode fast = head, slow = head, pre = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pre.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        return merge(first, second);
    }
    
    private ListNode merge(ListNode first, ListNode sec) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(first!=null && sec!=null) {
            if (first.val < sec.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = sec;
                sec = sec.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        
        if (first != null)  cur.next = first;
        if (sec != null)    cur.next = sec;
        return dummy.next;
    }
}