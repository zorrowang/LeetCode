package src.java.medium.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class RemoveDuplicatesSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy, cur = head;
        while (cur!=null) {
            ListNode temp = cur.next;
            if(temp==null || temp.val!=cur.val) {
                node.next = cur;
                node = node.next;
            } else{
                while(temp!=null && temp.val==cur.val)
                    temp = temp.next;
            }
            cur = temp;
        }
        node.next = null;
        return dummy.next;
    }
}