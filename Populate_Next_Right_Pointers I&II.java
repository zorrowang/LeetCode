/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root==null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> temp = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeLinkNode node = queue.poll();
            if (node.left!=null)    temp.offer(node.left);
            if (node.right!=null)   temp.offer(node.right);
            if (queue.isEmpty()){    
                queue = temp;
                temp = new LinkedList<TreeLinkNode>();
            }
            else    node.next=queue.peek();
        }
    }
}

// Non-BFS solution
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode preHead = root;
        
        while (preHead != null){
            TreeLinkNode curHead = null;
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
    }
    
    public TreeLinkNode getNext(TreeLinkNode node) {
        while (node!=null && node.left==null && node.right==null)
            node = node.next;
        return node!=null?(node.left!=null?node.left:node.right):null;
    }
}