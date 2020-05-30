package src.java.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import src.java.lib.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)   return ret;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right!=null)    stack.push(node.right);
            if (node.left!=null)    stack.push(node.left);
        }
        return ret;
    }
}