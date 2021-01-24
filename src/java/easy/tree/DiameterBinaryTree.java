package src.java.easy.tree;

public class DiameterBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)   return 0;
        int[] ret = dfs(root);
        return ret[1]-1;
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null)   return new int[]{0, 0};
        int[] ret = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        ret[0] = Math.max(left[0], right[0]) + 1;
        ret[1] = Math.max(left[1], Math.max(right[1], left[0] + right[0] +1));
        return ret;
    }
}