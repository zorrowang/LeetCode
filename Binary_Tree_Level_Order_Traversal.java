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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root==null) return ret;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
        queue.offer(root);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null)    temp.offer(node.left);
            if (node.right!=null)   temp.offer(node.right);
            if (queue.isEmpty() && !temp.isEmpty()){
                queue = temp;
                temp = new LinkedList<TreeNode>();
                ret.add(list);
                list = new ArrayList<Integer>();
            }
        }
        
        ret.add(list);
        return ret;
    }
}