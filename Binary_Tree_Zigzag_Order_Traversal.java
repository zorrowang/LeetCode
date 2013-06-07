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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root==null) return ret;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
        queue.offer(root);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i=0;
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if (i%2==1) list.add(0, node.val);
            else list.add(node.val);
            
            if (node.left!=null)    temp.offer(node.left);
            if (node.right!=null)   temp.offer(node.right);
            if (queue.isEmpty() && !temp.isEmpty()){
                queue = temp;
                temp = new LinkedList<TreeNode>();
                ret.add(list);
                list = new ArrayList<Integer>();
                i++;
            }
        }
        
        ret.add(list);
        return ret;
    }
}