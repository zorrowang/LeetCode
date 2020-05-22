package src.java.medium.tree;

import src.java.lib.TreeNode;

public class MaximumProductSplittedBinaryTree {
  // Passed: time & space O(n)
  // Build tree with sum value
  public int maxProduct(TreeNode root) {
      TreeNode sumRoot = build(root);
      return (int)(helper(root, 0, sumRoot) % (1e9+7));
  }
  
  public long helper(TreeNode root, long sum, TreeNode sumRoot) {
      long max = Long.MIN_VALUE;
      if (root.left==null && root.right==null)
          return max;
      sum += root.val;
      long sumLeft = root.left==null ? 0 : (long)sumRoot.left.val;
      long sumRight = root.right==null ? 0 : (long)sumRoot.right.val;
      if (root.left!=null) {
          max = Math.max(max, (sumRight+sum)*sumLeft);
          long left = helper(root.left, sum+sumRight, sumRoot.left);
          max = Math.max(left, max);
      }
      if (root.right!=null) {
          max = Math.max(max, (sumLeft+sum)*sumRight);
          long right = helper(root.right, sum+sumLeft, sumRoot.right);
          max = Math.max(right, max);
      }
      return max;
  }
  
  public TreeNode build(TreeNode root) {
      if (root==null )
          return null;
      TreeNode left = build(root.left);
      TreeNode right = build(root.right);
      int val = root.val;
      if (left != null) val += left.val;
      if (right != null) val += right.val;
      TreeNode node = new TreeNode(val);
      node.left = left;
      node.right = right;
      return node;
  }
}