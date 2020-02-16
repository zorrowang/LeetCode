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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head==null || n==0) return head;
        ListNode first = head;
        while(n>0){
            if(first==null) first=head;
            first = first.next;
            n--;
        }
        if(first==null) return head;
        ListNode second = head;
        while(first.next!=null){
            second = second.next;
            first = first.next;
        }
        first.next = head;
        ListNode ret = second.next;
        second.next = null;
        return ret;
    }
}

