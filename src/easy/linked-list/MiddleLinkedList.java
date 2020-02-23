package src.easy.linkedlist;

/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *    int val; 
 *    ListNode next; 
 *    ListNode(int x) { val = x; } 
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode first = head, second = head;
        while(second!=null && second.next!=null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }
}