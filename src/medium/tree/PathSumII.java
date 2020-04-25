package src.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, list, ret);
        return ret;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ret) {
        if (root==null) {
            return;
        } else if (root.left==null && root.right==null && sum==root.val) {
            List<Integer> l = new ArrayList<>(list);
            l.add(root.val);
            ret.add(l);
            return;
        } 
        
        list.add(root.val);
        pathSum(root.left, sum-root.val, list, ret);
        pathSum(root.right, sum-root.val, list, ret);
        list.remove(list.size()-1);
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