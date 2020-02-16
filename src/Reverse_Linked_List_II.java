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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n==m)   return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        
		//Find the start node
        n -= m;
        while(m>1){
            node = node.next;
            m--;
        }
        
		// Reverse the sublist
        ListNode addPoint = node.next;
        ListNode cur = node.next;
        while(n>=0){
            ListNode temp1 = cur.next;
            ListNode temp2 = node.next;
            node.next = cur;
            cur.next = temp2;
            cur = temp1;
            n--;
        }
		
		// Add the rest of list to the reversed list
        addPoint.next = cur;
        return dummy.next;
    }
}