package src.java.medium.tree;

import src.java.lib.TreeNode;

public class CountCompleteTreeNodes {
    // O(n)
    public int countNodes(TreeNode root) {
        if(root==null)  return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    // O(logn)
    public int countNodes2(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}