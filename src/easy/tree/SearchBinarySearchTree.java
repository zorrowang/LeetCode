package src.easy.tree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class SearchBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)   return null;
        if (root.val == val)    return root;
        else if (root.val > val)    return searchBST(root.left, val);
        else    return searchBST(root.right, val);
    }
}