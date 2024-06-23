package src.java.medium.tree;

import java.util.ArrayList;
import java.util.List;

import src.java.lib.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, targetSum, ret, new ArrayList<>());
        return ret;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> ret, List<Integer> cur) {
        if (root == null)   return;
        cur.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            List<Integer> list = new ArrayList<>(cur);
            ret.add(list);
        }
        dfs(root.left, targetSum - root.val, ret, cur);
        dfs(root.right, targetSum - root.val, ret, cur);
        cur.remove(cur.size() - 1);
    }

    // Legacy solution
    public ArrayList<ArrayList<Integer>> pathSum2(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root==null) return ret;
        if (root.left==null && root.right==null && root.val==sum){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            ret.add(list);
            return ret;
        }
        
        ArrayList<ArrayList<Integer>> left = pathSum2(root.left, sum-root.val);
        ArrayList<ArrayList<Integer>> right = pathSum2(root.right, sum-root.val);
        
        if (!left.isEmpty())
            ret.addAll(left);
        
        if (!right.isEmpty())
            ret.addAll(right);
            
        for(int i=0; i<ret.size(); i++)
            ret.get(i).add(0, root.val);
        
        return ret;
    }
}