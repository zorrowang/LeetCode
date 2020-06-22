package src.java.medium.tree;

import src.java.lib.TreeNode;

public class LargestBSTSubtree {
    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        // write your code here
        return dfs(root, null);
    }
    
    private TreeNode dfs(TreeNode root, TreeNode curMax) {
        if (root == null)   return curMax;
        TreeNode max = curMax==null || curMax.val<root.val ? root : curMax;
        TreeNode left = dfs(root.left, max);
        TreeNode right = dfs(root.right, max);
        return left.val > right.val ? left : right;
    }
}