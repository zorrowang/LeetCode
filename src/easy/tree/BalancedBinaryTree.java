package src.easy.tree;


public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
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

    // Brute-Force
    public boolean isBalanced2(TreeNode root) {
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