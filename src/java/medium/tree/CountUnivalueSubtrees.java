package src.java.medium.tree;

import src.java.lib.TreeNode;

public class CountUnivalueSubtrees {
    class Info {
        boolean isUni;
        int count;
        int val;
        Info (boolean isUni, int count, int val) {
            this.isUni = isUni;
            this.count = count;
            this.val = val;
        }
    }
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        Info ret = dfs(root);
        return ret.count;
    }
    
    private Info dfs(TreeNode root) {
        if (root==null) return new Info(true, 0, 0);
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        int count = left.count + right.count;
        if (left.isUni && right.isUni) {
            if (left.count == 0 && right.count == 0)
                return new Info(true, 1, root.val);
            else if (left.count == 0 && right.val == root.val) 
                return new Info(true, count+1, root.val);
            else if (right.count == 0 && left.val == root.val)
                return new Info(true, count+1, root.val);
            else if (right.val == root.val && left.val == root.val)
                return new Info(true, count+1, root.val);
            else
                return new Info(false, count, root.val);
        } else
            return new Info(false, count, root.val);
    }
}