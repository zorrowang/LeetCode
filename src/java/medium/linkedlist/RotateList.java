package src.java.medium.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class RotateList {
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0)   return head;
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        
        k = count - k%count;
        ListNode pre = null;
        cur = head;
        while(k > 0) {
            k--;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        
        if (cur==null)  return head;
        ListNode newHead = cur;
        while(cur.next != null) cur = cur.next;
        cur.next = head;
        return newHead;
    }

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

