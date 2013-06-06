/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
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
        
        ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum-root.val);
        ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum-root.val);
        
        if (!left.isEmpty())
            ret.addAll(left);
        
        if (!right.isEmpty())
            ret.addAll(right);
            
        for(int i=0; i<ret.size(); i++)
            ret.get(i).add(0, root.val);
        
        return ret;
    }
}