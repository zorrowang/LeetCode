package src.easy.tree;

public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root==null) 
            return 0;
        if (root.left==null && root.right==null)
            return 1;
        if (root.left==null || root.right==null)    
            return root.left==null?minDepth(root.right)+1:minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}