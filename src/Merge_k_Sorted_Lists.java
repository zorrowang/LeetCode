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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists==null || lists.isEmpty()) return null;
        
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(lists.size(), 
            new Comparator<ListNode>(){
                public int compare(ListNode node1, ListNode node2){
                    return (node1.val>node2.val)?1:(node1.val==node2.val?0:-1);
                }
            });
        for(int i=0; i<lists.size(); i++){
            if (lists.get(i)==null)
                continue;
            pQueue.offer(lists.get(i));
            
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(!pQueue.isEmpty()){
            ListNode temp = pQueue.poll();
            node.next = temp;
            node = node.next;
            if(temp.next!=null)
                pQueue.offer(temp.next);
        }
        return dummy.next;
    }
}

