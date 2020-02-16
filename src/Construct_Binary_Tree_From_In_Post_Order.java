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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart>iEnd || pStart>pEnd) 
            return null;
        
        int val = postorder[pEnd];
        int length=0;
        while(inorder[iStart+length]!=val)
            length++;
        
        TreeNode node = new TreeNode(val);
        TreeNode left = buildTree(inorder, iStart, iStart+length-1, postorder, pStart, pStart+length-1);
        TreeNode right = buildTree(inorder, iStart+length+1, iEnd, postorder, pStart+length, pEnd-1);
        node.left = left;
        node.right = right;
        return node;
    }
}

