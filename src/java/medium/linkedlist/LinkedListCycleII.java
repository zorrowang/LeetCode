package src.java.medium.linkedlist;


public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        boolean flag = false;
        ListNode first = head, second = head;
        while(second!=null && second.next!=null){
            first = first.next;
            second = second.next.next;
            if(first==second){
                flag = true;
                break;
            }
        }
        
        if (flag){
            second = head;
            while(first != second){
                first = first.next;
                second = second.next;
            }
            return second;
        }
        return null;
    }
}