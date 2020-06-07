package src.java.medium.linkedlist;


public class FlattenMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node[] ret = rec(head);
        return ret[0];
    }
    
    public Node[] rec(Node head) {
        Node[] ret = new Node[2];
        ret[0] = head;
        Node cur = head, tail = head;
        while(cur != null) {
            Node temp = null;
            tail = cur;
            if (cur.child != null) {
                Node[] children = rec(cur.child);
                temp = cur.next;
                cur.next = children[0];
                children[0].prev = cur;
                children[1].next = temp;
                if (temp != null)   temp.prev = children[1];
                cur.child = null;
            }
            if (temp != null)
                cur = temp;
            else
                cur = cur.next;
        }
        ret[1] = tail;
        return ret;
    }
}