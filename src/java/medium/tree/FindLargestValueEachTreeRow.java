package src.java.medium.tree;

import java.util.ArrayList;
import java.util.List;

import src.java.lib.TreeNode;

public class FindLargestValueEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret, 1);
        return ret;
    }
    
    private void dfs(TreeNode root, List<Integer> maxList, int level) {
        if (root == null)
            return;
        else if (level > maxList.size())
            maxList.add(root.val);
        else if (maxList.get(level - 1) < root.val) 
            maxList.set(level - 1, root.val);
        dfs(root.left, maxList, level + 1);
        dfs(root.right, maxList, level + 1);
    }
}