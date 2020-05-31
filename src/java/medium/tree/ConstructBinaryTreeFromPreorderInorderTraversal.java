package src.java.medium.tree;

import src.java.lib.TreeNode;

public class ConstructBinaryTreeFromPreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart>pEnd || iStart>iEnd)
            return null;
        int r = preorder[pStart];
        TreeNode node = new TreeNode(r);
        int index = -1;
        for (int i=iStart; i<=iEnd; i++) {
            if (inorder[i] == r) {
                index = i;
                break;
            }
        }
        node.left = build(preorder, pStart+1, pStart+index-iStart, inorder, iStart, index-1);
        node.right = build(preorder, pStart+index-iStart+1, pEnd, inorder, index+1, iEnd);
        return node;
    }
}