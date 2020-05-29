package src.java.medium.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class SwapNodesPairs {
    // Recursive solution
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode node = swapPairs(next.next);
        next.next = head;
        head.next = node;
        return next;
    }

    // Legacy solution
    public ListNode swapPairs2(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(head!=null&&head.next!=null){
            ListNode temp = head.next.next;
            node.next = head.next;
            node = node.next;
            node.next = head;
            node = node.next;
            head = temp;
        }
        
        if(head!=null){
            node.next = head;
            node = node.next;
        }
        node.next = null;
        return dummy.next;
    }
}

