package src.hard.tree;

import java.util.Arrays;
import java.util.LinkedList;

import src.lib.TreeNode;



class SerializeDeserializeBinaryTree {
    private static final String delimiter = ",";
    private static final String NULL = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeRec(root, sb);
        return sb.toString();
    }

    private void serializeRec(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append(NULL).append(delimiter);
        else {
            sb.append(root.val).append(delimiter);
            serializeRec(root.left, sb);
            serializeRec(root.right, sb);
        }
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(delimiter)));
        return deserializeRec(queue);
    }

    private TreeNode deserializeRec(LinkedList<String> queue) {
        String val = queue.poll();
        if (val.equals(NULL))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = deserializeRec(queue);
            node.right = deserializeRec(queue);
            return node;
        }
    }
}