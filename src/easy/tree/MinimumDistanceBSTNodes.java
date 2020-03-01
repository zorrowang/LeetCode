package src.easy.tree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class MinimumDistanceBSTNodes {
  public int minDiffInBST(TreeNode root) {
      return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }
  
  public int dfs(TreeNode root, int left, int right) {
      if (root==null)   return Integer.MAX_VALUE;
      
      int retLeft = root.val>=left ? root.val-left : Integer.MAX_VALUE;
      int retRight = root.val<=right ? right-root.val : Integer.MAX_VALUE;
      int ret = Math.min(retLeft, retRight);
      
      retLeft = dfs(root.left, left, root.val);
      retRight = dfs(root.right, root.val, right);
      ret = Math.min(ret, Math.min(retLeft, retRight));
      
      return ret;
  }
}