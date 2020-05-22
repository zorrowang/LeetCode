package src.java.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import src.java.lib.TreeNode;

public class BinaryTreeInorderTraversal {
    // Recursive solution
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderTraversal(root, ret);
        return ret;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> ret) {
        if (root==null) return;
        inorderTraversal(root.left, ret);
        ret.add(root.val);
        inorderTraversal(root.right, ret);
    }

    // Iterative solution
    public List<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<Integer> ret = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        TreeNode node = root;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            ret.add(temp.val);
            if(temp.right!=null){
                temp = temp.right;
                while(temp!=null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        
        return ret;
    }
}

