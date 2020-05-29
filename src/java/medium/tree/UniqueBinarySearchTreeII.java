package src.java.medium.tree;

import java.util.ArrayList;

import src.java.lib.TreeNode;

public class UniqueBinarySearchTreeII {
    // Recursive solution
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n==0)   return new ArrayList<TreeNode>();
        return generateTrees(n, 0);
    }
    
    public ArrayList<TreeNode> generateTrees(int n, int offset) {
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

