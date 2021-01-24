package src.java.medium.tree;

import java.util.LinkedList;
import src.java.lib.TreeNode;

public class CheckCompletenessBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)   return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isNull) return false;
                else    queue.offer(node.left);
            } else {
                isNull = true;
            }
            
            if (node.right != null) {
                if (isNull) return false;
                else    queue.offer(node.right);
            } else {
                isNull = true;
            }
        }
        return true;
    }
}