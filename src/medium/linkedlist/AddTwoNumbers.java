package src.medium.linkedlist;

class ListNode {
    int val;
    ListNode next;
    ListNode(int v) {
        val = v;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Start typing your Java solution below
            // DO NOT write main() function
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            int flow = 0;
            
            while(l1!=null && l2!=null){
                int val = l1.val+l2.val+flow;
                if (val>=10){
                    val %= 10;
                    flow = 1;
                }
                else
                    flow = 0;
                ListNode node = new ListNode(val);
                head.next = node;
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            while(l1!=null){
                int val = l1.val+flow;
                if (val>=10){
                    val %= 10;
                    flow = 1;
                }
                else
                    flow = 0;
                ListNode node = new ListNode(val);
                head.next = node;
                head = head.next;
                l1 = l1.next;
            }
            
            while(l2!=null){
                int val = l2.val+flow;
                if (val>=10){
                    val %= 10;
                    flow = 1;
                }
                else
                    flow = 0;
                ListNode node = new ListNode(val);
                head.next = node;
                head = head.next;
                l2 = l2.next;
            }
            
            if(flow > 0){
                ListNode node = new ListNode(flow);
                head.next = node;
            }
            
            return dummy.next;
        }
}
