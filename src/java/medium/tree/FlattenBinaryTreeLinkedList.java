package src.java.medium.tree;

import java.util.LinkedList;

import src.java.lib.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class FlattenBinaryTreeLinkedList {
    public void flatten(TreeNode root) {
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

    // Recursive solution
    public void flatten2(TreeNode root) {
        flattenHelper(root);
    }
    
    public TreeNode[] flattenHelper(TreeNode root){
        TreeNode[] ret = new TreeNode[2];
        if (root==null)
            return null;
        if (root.left==null && root.right==null){
            ret[0] = root;
            ret[1] = root;
            return ret;
        }
        
        TreeNode[] left = flattenHelper(root.left);
        TreeNode[] right = flattenHelper(root.right);
        
        ret[0] = root;
        root.left = null;
        if(left!=null){
            root.right = left[0];
            root = left[1];
        }
        if(right!=null){
            root.right = right[0];
            root = right[1];
        }
        ret[1] = root;
        return ret;
    }
}
