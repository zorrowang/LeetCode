package src.java.easy.tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode p, TreeNode q){
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        return p.val==q.val&&isSymmetric(p.left, q.right)&&isSymmetric(p.right, q.left);
    }
}