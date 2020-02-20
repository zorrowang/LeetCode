package src.easy.tree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class SubtreeOfAnotherTree {
    // Brute-force solution
    // Runtime: 5 ms, faster than 96.90% of Java online submissions for Subtree of Another Tree.
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)  return false;
        if (helper(s, t))   return true;
        else return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean helper(TreeNode s, TreeNode t) {
        if (s==null && t==null) return true;
        if (s==null || t==null) return false;
        if (s.val != t.val) return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}