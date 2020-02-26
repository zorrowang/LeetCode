package src.easy.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head==null)  return head;
        ListNode node = head;
        ListNode cur = head.next;
        
        while(cur!=null){
            if (node.val==cur.val)
                cur = cur.next;
            else{
                node.next = cur;
                node = node.next;
                cur = cur.next;
            }
        }
        
        //Set the end of new linked list
        node.next = null;
        return head;
    }
}