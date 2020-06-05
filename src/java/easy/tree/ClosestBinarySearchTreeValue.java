package src.java.easy.tree;

public class ClosestBinarySearchTreeValue {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if(root.val == target)  return root.val;
        int ret = root.val;
        if (root.val < target && root.right != null)
            ret = closestValue(root.right, target);
        else if (root.val > target && root.left != null)
            ret = closestValue(root.left, target);
        if (ret != root.val && Math.abs(ret-target)<Math.abs(root.val-target))
            return ret;
        return root.val;
    }

    // Use global variable
    int ret = 0;
    public int closestValue2(TreeNode root, double target) {
        // write your code here
        ret = root.val;
        helper(root, target);
        return ret;
    }
    
    public void helper(TreeNode node, double target) {
        if (node == null)   return;
        if (Math.abs(node.val-target) < Math.abs(ret-target))
            ret = node.val;
        if (node.val == target) return;
        else if (node.val > target) helper(node.left, target);
        else helper(node.right, target);
    }
}