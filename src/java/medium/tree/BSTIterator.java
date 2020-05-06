package src.java.medium.tree;

import java.util.LinkedList;

public class BSTIterator {
    LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node.right;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}