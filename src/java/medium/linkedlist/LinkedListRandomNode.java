package src.java.medium.linkedlist;

import java.util.Random;

public class LinkedListRandomNode {
    
    ListNode head;
    Random random;
    
    public LinkedListRandomNode(ListNode head) {
        this.head = head;                
    }
    
    public int getRandom() {
        ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){
            c = c.next;
            if(randInt(0,i) == i) r = c.val;                        
        }
        return r;
    }
    
    private int randInt(int min, int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }
}