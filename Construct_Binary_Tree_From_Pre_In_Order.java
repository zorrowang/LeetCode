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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart>pEnd || iStart>iEnd) return null;        
        
        int val = preorder[pStart];
        int length = 0;
        while(inorder[iStart+length]!=val)
            length++;
            
        TreeNode node = new TreeNode(val);
        TreeNode left = buildTree(preorder, pStart+1, pStart+length, inorder, iStart, iStart+length-1);
        TreeNode right = buildTree(preorder, pStart+length+1, pEnd, inorder, iStart+length+1, iEnd);
        node.left = left;
        node.right = right;
        return node;
    }
}

