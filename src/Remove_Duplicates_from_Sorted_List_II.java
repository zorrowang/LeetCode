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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(head!=null){
            ListNode temp = head.next;
            if(temp==null || temp.val!=head.val){
                node.next = head;
                node = node.next;
            }
            else{
                while(temp!=null && temp.val==head.val)
                    temp = temp.next;
            }
            head = temp;
        }
        node.next = null;
        return dummy.next;
    }
}