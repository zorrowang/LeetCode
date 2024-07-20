package src.java.hard.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import src.java.lib.TreeNode;



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
        if (root == null) {
            sb.append(NULL).append(delimiter);
            return;
        }
        sb.append(root.val).append(delimiter);
        serializeRec(root.left, sb);
        serializeRec(root.right, sb);
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(delimiter)));
        return deserializeRec(queue);
    }

    private TreeNode deserializeRec(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals(NULL))   return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeRec(queue);
        node.right = deserializeRec(queue);
        return node;
    }
}

// legacy solution
class Codec {
    private static String delimiter = ",";
    private class Pair {
        TreeNode node;
        String data;
        Pair(TreeNode node, String data) {
            this.node = node;
            this.data = data;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)   return "#";
        return root.val + delimiter + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Pair p = helper(data);
        return p.node;
    }

    public Pair helper(String data) {
        if (data.charAt(0) == '#')  return new Pair(null, data.substring(1));
        int ind = 0;
        while (ind < data.length() && data.charAt(ind) != ',' && data.charAt(ind) != '#')
            ind++;
        TreeNode node = new TreeNode(Integer.parseInt(data.substring(0, ind)));
        if (data.charAt(ind) == ',')  ind++;
        Pair p = helper(data.substring(ind));
        node.left = p.node;
        if (!p.data.isEmpty())
            p = helper(p.data);
        node.right = p.node;
        return new Pair(node, p.data);
    }
}
