/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = maxPathSumHelper(root);
        return ret[0];
    }
    
    public int[] maxPathSumHelper(TreeNode root) {
        int[] ret = new int[2];
        if (root==null) return null;
        
        int[] left = maxPathSumHelper(root.left);
        int[] right = maxPathSumHelper(root.right);
        
        ret[1] = root.val;
        if(left!=null && right!=null)
            ret[1] += Math.max(Math.max(left[1], right[1]), 0);
        else if (left!=null || right!=null)
            ret[1] += (left!=null)?Math.max(left[1], 0):Math.max(right[1], 0);
        
        ret[0] = root.val;
        if(left!=null && right!=null){
            ret[0] += (left[1]>0)?left[1]:0;
            ret[0] += (right[1]>0)?right[1]:0;
        }
        else if (left!=null || right!=null){
            ret[0] += (left!=null&&left[1]>0)?left[1]:0;
            ret[0] += (right!=null&&right[1]>0)?right[1]:0;
        }
        
        if (left!=null) ret[0] = Math.max(ret[0], left[0]);
        if (right!=null) ret[0] = Math.max(ret[0], right[0]);
        return ret;
    }
}

// Improve the code to make it more precise
public class Solution {
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
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