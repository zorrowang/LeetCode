package src.java.medium.tree;

import java.util.LinkedList;

import src.java.lib.TreeNode;

public class BinaryTreeUpsideDown {
    /**
     * @param root: the root of binary tree
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, newRoot = null;
        while(cur!=null) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode pre = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (newRoot == null) {
                newRoot = node;
                pre = node;
            }
            if (node.right!=null)
                pre.left = node.right;
            pre.right = node;
            node.left = node.right = null;
            pre = node;
        }
        return newRoot;
    }
}