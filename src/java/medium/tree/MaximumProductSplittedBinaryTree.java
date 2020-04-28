package src.java.medium.tree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class MaximumProductSplittedBinaryTree {
  // Time Limit Exceeded
  public int maxProduct(TreeNode root) {
    return (int)(helper(root, 0) % (1e9+7));
  }

  public long helper(TreeNode root, long sum) {
      long max = Long.MIN_VALUE;
      if (root.left==null && root.right==null)
          return max;
      sum += root.val;
      long sumLeft = sum(root.left);
      long sumRight = sum(root.right);
      if (root.left!=null) {
          max = Math.max(max, (sumRight+sum)*sumLeft);
          long left = helper(root.left, sum+sumRight);
          max = Math.max(left, max);
      }
      if (root.right!=null) {
          max = Math.max(max, (sumLeft+sum)*sumRight);
          long right = helper(root.right, sum+sumLeft);
          max = Math.max(right, max);
      }
      return max;
  }

  public long sum(TreeNode root) {
      if (root==null)
          return 0;
      return root.val + sum(root.left) + sum(root.right);
  }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}



class MaximumProductSplittedBinaryTree2 {
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