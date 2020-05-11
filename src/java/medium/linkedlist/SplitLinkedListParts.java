package src.java.medium.linkedlist;

public class SplitLinkedListParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        
        ListNode[] ret = new ListNode[k];
        int avg = count/k;
        int left = count%k;
        cur = root;
        for (int i=0; i<k; i++) {
            ret[i] = cur;
            ListNode pre = cur;
            for (int j=0; j<avg; j++) {
                pre = cur;
                cur = cur.next;
            }
            if (left > 0) {
                pre = cur;
                cur = cur.next;
                left--;
            }
            if (pre != null)    pre.next = null;
        }
        
        return ret;
    }
}