package src.java.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.java.lib.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map, 0);
        return build(map);
    }
    
    private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int col) {
        if (root==null) return;
        if (map.containsKey(col))
            map.get(col).add(root.val);
        else
            map.put(col, new ArrayList<>(Arrays.asList(root.val)));
        dfs(root.left, map, col-1);
        dfs(root.right, map, col+1);
    } 
    
    private List<List<Integer>> build(Map<Integer, List<Integer>> map) {
        List<List<Integer>> ret = new ArrayList<>();
        int minKey = Integer.MAX_VALUE;
        for (Integer k : map.keySet())
            minKey = Math.min(minKey, k);
        int cur = minKey;
        while (map.containsKey(cur))
            ret.add(map.get(cur++));
        return ret;
    }
}