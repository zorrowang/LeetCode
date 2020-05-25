package src.java.medium.tree;

import src.java.lib.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        // write your code here
        helper(root, root.val, 0);
        return max;
    }
    
    private void helper(TreeNode node, int pre, int con) {
        if (node == null)   return;
        if (node.val-pre==1) {
            con += 1;
        } else {
            con = 1;
        }
        max = Math.max(con, max);
        helper(node.left, node.val, con);
        helper(node.right, node.val, con);
    }
}