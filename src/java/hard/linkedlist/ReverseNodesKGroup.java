package src.java.hard.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class ReverseNodesKGroup {

    // Recursive solution beats 100%, written on 2021/01/17
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1)   return head;
        int cnt = 1;
        ListNode cur = head;
        for (; cnt < k; cnt++) {
            if (cur == null) return head;
            cur = cur.next;
        }
        if (cur == null)    return head;
        ListNode newHead = reverseKGroup(cur.next, k);
        cur.next = null;
        ListNode[] l = reverse(head);
        l[1].next = newHead;
        return l[0];
    }

    private ListNode[] reverse(ListNode head) {
        ListNode tail = head;
        ListNode prev = head, cur = head.next;
        prev.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        ListNode[] ret = new ListNode[2];
        ret[0] = prev;
        ret[1] = tail;
        return ret;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || head.next==null || k==1)  return head;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int t = 1; 
        ListNode tempHead=head, tempEnd=head;
        
        while(head!=null){
            if (t>k){
                t=1;
                reverse(tempHead, tempEnd);
                node.next=tempEnd;
                node=tempHead;
            }
            if (t==1)   tempHead = head;
            if (t==k)   tempEnd = head;
            head = head.next;
            t++;
        }
        
        if (t>k){
            reverse(tempHead, tempEnd);
            node.next=tempEnd;
            node=tempHead;
            node.next=null;
        }
        else
            node.next = tempHead;
        
        return dummy.next;
    }
    
    public void reverse(ListNode head, ListNode end){
        ListNode dummy = new ListNode(0);
        ListNode newEnd = end.next;
        while(head!=newEnd){
            ListNode node = dummy.next;
            ListNode temp = head.next;
            dummy.next = head;
            head.next = node;
            head = temp;
        }
    }
}

