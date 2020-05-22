package src.java.medium.tree;

public class PopulatingNextRightPointersII {
    public Node connect(Node root) {
        Node preHead = root;
        
        while (preHead != null){
            Node curHead = null;
            while (preHead != null){
                if (preHead.left != null){
                    if (preHead.right != null)  
                        preHead.left.next = preHead.right;
                    else
                        preHead.left.next = getNext(preHead.next);
                    if (curHead==null)
                        curHead = preHead.left;
                }
                
                if (preHead.right != null) {
                    preHead.right.next = getNext(preHead.next);
                    if (curHead==null)
                        curHead = preHead.right;
                }
                
                preHead = preHead.next;
            }
            preHead = curHead;
        }
        return root;
    }
    
    public Node getNext(Node node) {
        while (node!=null && node.left==null && node.right==null)
            node = node.next;
        return node!=null?(node.left!=null?node.left:node.right):null;
    }
}