package src.easy.linkedlist;

public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        boolean endA = false, endB = false;
        
        while(curA != curB) {   
            if (curA == null || curB == null)
                return null;

            curA = curA.next;
            if (curA == null && !endA) {
                curA = headB;
                endA = true;
            }
            
            curB = curB.next;
            if (curB == null && !endB) {
                curB = headA;
                endB = true;
            }
        }
        return curA;
    }
}
