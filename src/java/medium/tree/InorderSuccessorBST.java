package src.java.medium.tree;

import src.java.lib.TreeNode;

public class InorderSuccessorBST {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null)   return null;
        if (p.right != null)    return min(p.right);
        
        TreeNode ret = null;
        while (root != null) {
            if (root.val > p.val) {
                ret = root;
                root = root.left;
            } else if (root.val < p.val)
                root = root.right;
            else
                break;
        }
        return ret;
    }
    
    public TreeNode min(TreeNode root) {
        while (root.left != null)   root = root.left;
        return root;
    }
}