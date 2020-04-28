package src.java.easy.tree;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
 
class LeafSimilarTrees {
  public boolean leafSimilar(final TreeNode root1, final TreeNode root2) {
    final String str1 = leafGen(root1);
    final String str2 = leafGen(root2);
    return str1.equals(str2);
  }

  private String leafGen(final TreeNode root) {
      if (root == null)   return "";
      if (root.left==null && root.right==null)    return String.valueOf(root.val);
      return leafGen(root.left) + leafGen(root.right);
  }
}