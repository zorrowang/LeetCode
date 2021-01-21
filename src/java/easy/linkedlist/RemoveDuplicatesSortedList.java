package src.java.easy.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head, sec = head.next;
        while (sec != null) {
            if (sec.val != first.val) {
                first = first.next;
                first.val = sec.val;
            }
            sec = sec.next;
        }
        first.next = null;
        return head;
    }
}