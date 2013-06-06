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