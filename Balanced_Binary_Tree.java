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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root==null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth(TreeNode root){
        if (root==null) return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }
}

// Improve performance to O(n)
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret = getHeight(root);
        return ret!=-1;
    }
    
    public int getHeight(TreeNode root) {
        if (root==null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left==-1||right==-1||Math.abs(left-right)>1)
            return -1;
        return Math.max(left, right)+1;
    }
}