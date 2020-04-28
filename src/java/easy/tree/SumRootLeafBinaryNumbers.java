package src.java.easy.tree;

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null)   return 0;
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int num) {
        num = num*2 + root.val;
        if (root.left == null && root.right == null)
            return num;
        int sum = 0;
        if (root.left != null)  sum += helper(root.left, num);
        if (root.right != null) sum += helper(root.right, num);
        return  sum;
    }
}