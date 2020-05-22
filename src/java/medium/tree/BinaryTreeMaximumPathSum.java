package src.java.medium.tree;

import src.java.lib.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreeMaximumPathSum {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathRec(root);
        return maxValue;
    }
    
    private int maxPathRec(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathRec(node.left));
        int right = Math.max(0, maxPathRec(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    // Solution w/o global variable
    public int maxPathSum2(TreeNode root) {
        int[] ret = maxPathSumHelper(root);
        return ret[0];
    }
    
    public int[] maxPathSumHelper(TreeNode root) {
        int[] ret = new int[2];
        if (root==null){
            ret[0] = Integer.MIN_VALUE;
            ret[1] = Integer.MIN_VALUE;
            return ret;
        }
        
        int[] left = maxPathSumHelper(root.left);
        int[] right = maxPathSumHelper(root.right);
        
        ret[1] = root.val;
        int temp1 = (left[1]>0)?left[1]:0;
        int temp2 = (right[1]>0)?right[1]:0;
        ret[1] += Math.max(temp1, temp2);
        
        ret[0] = Math.max(root.val+temp1+temp2, Math.max(left[0], right[0]));
        
        return ret;
    }
}