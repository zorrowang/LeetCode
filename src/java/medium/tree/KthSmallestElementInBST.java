package src.java.medium.tree;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
  public int kthSmallest(TreeNode root, int k) {
      LinkedList<TreeNode> stack = new LinkedList<>();
      int count = 0;
      
      while(root != null) {
          stack.push(root);
          root = root.left;
      }
      
      while(!stack.isEmpty()) {
          TreeNode node = stack.pop();
          if (++count == k)   return node.val;
          
          if (node.right != null) {
              node = node.right;
              while(node != null) {
                  stack.push(node);
                  node = node.left;
              }
          }
      }
      return -1;
  }
}