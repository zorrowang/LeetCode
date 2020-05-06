package src.java.medium.tree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);       
    }
    
    public int sumNumbersHelper(TreeNode root, int val){
        if (root==null) return 0;
        int v = val*10+root.val;
        if (root.left==null&&root.right==null)  return v;
        return sumNumbersHelper(root.left, v) + sumNumbersHelper(root.right, v);
    }
}