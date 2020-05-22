package src.java.medium.tree;

import src.java.lib.TreeNode;

public class SumOfNodesEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null)    return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int l = 0, r = 0;
        if (left != null)
            l += dfs(left.left, left.val, root.val) + dfs(left.right, left.val, root.val);
        if (right != null)
            r += dfs(right.left, right.val, root.val) + dfs(right.right, right.val, root.val);
        return l+r;
    }
    
    private int dfs(TreeNode root, int parent, int grandparent) {
        if (root == null)   return 0;
        int left = dfs(root.left, root.val, parent);
        int right = dfs(root.right, root.val, parent);
        int ret = 0;
        if (grandparent%2 == 0) ret += root.val;
        ret += left + right;
        return ret;
    }
}