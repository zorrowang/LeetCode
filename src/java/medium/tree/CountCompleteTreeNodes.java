package src.java.medium.tree;

public class CountCompleteTreeNodes {
    // O(n)
    public int countNodes(TreeNode root) {
        if(root==null)  return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}