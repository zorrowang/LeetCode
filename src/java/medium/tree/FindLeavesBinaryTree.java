package src.java.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import src.java.lib.TreeNode;

public class FindLeavesBinaryTree {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> ret = new LinkedList<>();
        dfs(root, ret);
        return ret;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> ret) {
        if (root==null) return -1;
        if (root.left==null && root.right==null) {
            if (ret.isEmpty())  ret.add(new ArrayList<>());
            ret.get(0).add(root.val);
            return 0;
        }
        int left = dfs(root.left, ret);
        int right = dfs(root.right, ret);
        int level = Math.max(left, right) + 1;
        if (ret.size() == level) ret.add(new ArrayList<>());
        ret.get(level).add(root.val);
        return level;
    }
}