/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(n, 0);

    }
    
    public ArrayList<TreeNode> generateTrees(int n, int offset) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if (n<=0){
            ret.add(null);
            return ret;
        }
        
        for (int i=1; i<=n; i++){
            ArrayList<TreeNode> list1 = generateTrees(i-1, offset);
            ArrayList<TreeNode> list2 = generateTrees(n-i, i+offset);
                
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();                
            for (TreeNode node : list1){
                TreeNode root = new TreeNode(i+offset);
                root.left = node;
                temp.add(root);
            }
                
            for (TreeNode node1 : list2){
                for (TreeNode node2 : temp){
                    TreeNode node = new TreeNode(node2.val);
                    node.left = node2.left;
                    node.right = node1;
                    ret.add(node);
                }
            }
        }
        
        return ret;

    }
}

