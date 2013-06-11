/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode dummy = new TreeNode(0);
        TreeNode temp = dummy;
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        if (root!=null) stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            temp.right = node;
            if (node.right!=null)  stack.push(node.right);
            if (node.left!=null)  stack.push(node.left);
            node.left=null;
            temp = temp.right;
        }        
    }
}