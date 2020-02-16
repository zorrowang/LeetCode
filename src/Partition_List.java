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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode small = dummy1, large = dummy2;
        while(head!=null){
            if (head.val<x){
                small.next = head;
                head = head.next;
                small = small.next;
            }
            else{
                large.next = head;
                head = head.next;
                large = large.next;
            }
        }
        
        small.next = dummy2.next;
        large.next = null;
        return dummy1.next;
    }
}