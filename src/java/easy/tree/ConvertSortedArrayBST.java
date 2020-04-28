package src.java.easy.tree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ConvertSortedArrayBST {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sortedArrayToBST(num, 0, num.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int start, int end){
        if (start>end)  return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(num[mid]);
        TreeNode left = sortedArrayToBST(num, start, mid-1);
        TreeNode right = sortedArrayToBST(num, mid+1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}

