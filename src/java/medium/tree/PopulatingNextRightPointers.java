package src.java.medium.tree;

import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        Node head = root;
        while (root!=null && root.left!=null) {
            Node left = root.left;
            while (root!=null) {
                root.left.next = root.right;
                if (root.next!=null)    
                    root.right.next = root.next.left;
                root = root.next;
            }
            root = left;
        }
        return head;
    }

    // Legacy solution using stack
    public void connect2(Node root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root==null) return;
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Node> temp = new LinkedList<Node>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left!=null)    temp.offer(node.left);
            if (node.right!=null)   temp.offer(node.right);
            if (queue.isEmpty()){    
                queue = temp;
                temp = new LinkedList<Node>();
            }
            else    node.next=queue.peek();
        }
    }
}
