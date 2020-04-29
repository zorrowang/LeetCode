package src.java.medium.tree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null)
            return true;
        return root.val<max && root.val>min && isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
}