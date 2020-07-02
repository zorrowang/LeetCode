package src.java.medium.linkedlist;

import java.util.LinkedList;

import src.java.lib.ListNode;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)   return l1==null?l2:l1;
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int val = carry;
            if (!s1.isEmpty())  val += s1.pop();
            if (!s2.isEmpty())  val += s2.pop();
            carry = val / 10;
            val %= 10;
            ListNode n = new ListNode(val, dummy.next);
            dummy.next = n;
        }
        if (carry > 0)
            return new ListNode(carry, dummy.next);
        return dummy.next;
    }
}