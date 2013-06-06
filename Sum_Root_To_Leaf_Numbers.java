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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sumNumbersHelper(root, 0);       
    }
    
    public int sumNumbersHelper(TreeNode root, int val){
        if (root==null) return 0;
        if (root.left==null&&root.right==null)  return val*10+root.val;
        return sumNumbersHelper(root.left, val*10+root.val)+sumNumbersHelper(root.right, val*10+root.val);
    }
}