package src.java.medium.tree;

import src.java.lib.TreeNode;

public class FindBottomLeftTreeValue {
    int curLevel, leftmost;
    public int findBottomLeftValue(TreeNode root) {
        curLevel = 0;
        dfs(root, 1);
        return leftmost;
    }
    
    public void dfs(TreeNode root, int level) {
        if (root == null)   return;
        if (curLevel < level) {
            curLevel = level;
            leftmost = root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}