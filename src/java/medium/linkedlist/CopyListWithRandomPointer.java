package src.java.medium.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Map<Integer, Node> indexToNode = new HashMap<>();
        
        int index = 0;
        Node dummy = new Node(0);
        Node cur = head, pre = dummy;
        while(cur != null) {
            Node n = new Node(cur.val);
            pre.next = n;
            pre = n;
            nodeToIndex.put(cur, index);
            cur = cur.next;
            indexToNode.put(index++, n);
        }
        cur = head;
        Node node = dummy.next;
        while(cur != null) {
            if (cur.random != null) {
                int i = nodeToIndex.get(cur.random);
                node.random = indexToNode.get(i);
            }
            cur = cur.next;
            node = node.next;
        }
        return dummy.next;
    }
}