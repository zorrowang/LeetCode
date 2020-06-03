package src.java.hard.tree;

import java.util.ArrayList;
import java.util.Arrays;

import src.java.lib.TreeNode;

public class RecoverBinarySearchTree {
    // O(n) space solution
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        
        searchTree(root, nodeList, numList);
        int[] array = new int[numList.size()];
        int i=0;
        for(int num : numList)
            array[i++] = num;
        Arrays.sort(array);
        for(i=0; i<nodeList.size(); i++)
            nodeList.get(i).val = array[i];
        
    }
    
    public void searchTree(TreeNode root, ArrayList<TreeNode> nodeList, ArrayList<Integer> numList){
        if (root==null) return;
        searchTree(root.left, nodeList, numList);
        nodeList.add(root);
        numList.add(root.val);
        searchTree(root.right, nodeList, numList);
    }
}

