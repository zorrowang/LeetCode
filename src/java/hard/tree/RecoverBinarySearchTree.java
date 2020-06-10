package src.java.hard.tree;

import java.util.ArrayList;
import java.util.Arrays;

import src.java.lib.TreeNode;

public class RecoverBinarySearchTree {
    // Morris Traversal
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, prev = null;
        TreeNode first = null, second = null;
        TreeNode temp = null;
        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev.val > cur.val) {
                    if (first == null) {
                        first = prev;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            } else {
                temp = cur.left;
                while (temp.right != null && temp.right != cur)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    if (prev != null && prev.val > cur.val) {
                        if (first == null) {
                            first = prev;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    prev = cur;
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
        
        // swap two node values;
		if (first != null && second != null) {
		    int t = first.val;
		    first.val = second.val;
		    second.val = t;
		}
    }

    // O(n) space solution
    public void recoverTree2(TreeNode root) {
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

