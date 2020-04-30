package src.java.medium.backtracking;

import src.java.lib.*;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null)   return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        int sum1 = root.val;
        if (left != null)
            sum1 += rob(left.left) + rob(left.right);
        if (right != null)
            sum1 += rob(right.left) + rob(right.right);
        
        int sum2 = rob(left) + rob(right);
        
        return Math.max(sum1, sum2);
    }
}