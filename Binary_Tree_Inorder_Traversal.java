/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursive solution
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        inorderTraversal(root, ret);
        return ret;
    }
    
    public void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if(root==null)  return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}

// Iterative solultion
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        TreeNode node = root;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            ret.add(temp.val);
            if(temp.right!=null){
                temp = temp.right;
                while(temp!=null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        
        return ret;
    }
}

