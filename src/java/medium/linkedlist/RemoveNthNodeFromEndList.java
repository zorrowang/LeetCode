package src.java.medium.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class RemoveNthNodeFromEndList {
    // 1. Check edge case: remove head node
    // 2. When checking node.next, ensure check node before
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode first = head; 
        while(n>0){
            first = first.next;
            n--;
        }
        ListNode second = head;
        while(first!=null && first.next!=null){
            first = first.next;
            second = second.next;
        }
        
        if (second==head && first==null){
            head = head.next;
            return head;
        }
        second.next = second.next.next;
        return head;
    }
}

