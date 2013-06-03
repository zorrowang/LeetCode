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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
            else{
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
            head.next = null;
        }
        
        if (l1!=null)   head.next = l1;
        if (l2!=null)   head.next = l2;
        
        return dummy.next;
    }
}