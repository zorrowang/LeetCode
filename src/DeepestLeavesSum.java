package src;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Pair {
    int val;
    int pos;
    Pair(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }
}

class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Pair ret = helper(root, 1);
        return ret.val;
    }
    
    private Pair helper(TreeNode root, int level) {
        if (root == null)
            return new Pair(0, -1);
        if (root.left == null && root.right == null)
            return new Pair(root.val, level);
        
        Pair left = helper(root.left, level+1);
        Pair right = helper(root.right, level+1);
        
        if (left.pos == right.pos)
            return new Pair(left.val + right.val, left.pos);
        else if (left.pos > right.pos)
            return left;
        else
            return right;
    }
}
