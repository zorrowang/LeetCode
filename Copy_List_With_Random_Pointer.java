/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<RandomListNode, Integer> map1 = new HashMap<RandomListNode, Integer>();
        HashMap<Integer, RandomListNode> map2 = new HashMap<Integer, RandomListNode>();
        
        RandomListNode current = head;
        RandomListNode newHead=null, newCurrent=null, prev=null;
        int i=0;
        while(current!=null){
            map1.put(current, i);
            newCurrent = new RandomListNode(current.label);
            if (i==0){
                newHead = newCurrent;
                prev = newHead;
            }
            else{
                prev.next = newCurrent;
                prev = newCurrent;
            }
            map2.put(i, newCurrent);
            current = current.next;
            i++;
        }
        
        current = head;
        newCurrent = newHead;
        while(current!=null){
            if (current.random==null){
                newCurrent.random = null;
            }
            else{
                int index = map1.get(current.random);
                newCurrent.random = map2.get(index);
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }
        
        return newHead;
    }
}