package src.java.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.java.lib.TreeNode;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> dis = new ArrayList<>();
        int ret = 0;
        dfs(root, dis, 1, 1);
        for (List<Integer> list : dis)
            ret = Math.max(list.get(1) - list.get(0) + 1, ret);
        return ret;
    }
    
    private void dfs(TreeNode node, List<List<Integer>> dis, int pos, int level) {
        if (node == null)   return;
        if (dis.size() < level) 
            dis.add(new ArrayList<>(Arrays.asList(pos, pos)));
        else if (dis.get(level-1).get(1) < pos)
            dis.get(level-1).set(1, pos);
        dfs(node.left, dis, pos*2-1, level+1);
        dfs(node.right, dis, pos*2, level+1);
    }
}