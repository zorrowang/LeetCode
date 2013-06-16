/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
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

