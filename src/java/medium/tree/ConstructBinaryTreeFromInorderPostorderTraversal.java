package src.java.medium.tree;

import src.java.lib.TreeNode;

public class ConstructBinaryTreeFromInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart>pEnd || iStart>iEnd)
            return null;
        int r = postorder[pEnd];
        TreeNode node = new TreeNode(r);
        int index = -1;
        for (int i=iStart; i<=iEnd; i++) {
            if (inorder[i] == r) {
                index = i;
                break;
            }
        }
        node.left = build(postorder, pStart, pStart+index-iStart-1, inorder, iStart, index-1);
        node.right = build(postorder, pStart+index-iStart, pEnd-1, inorder, index+1, iEnd);
        return node;
    }
}