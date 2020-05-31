package src.java.hard.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import src.java.lib.TreeNode;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right!=null && !visited.contains(node)) {
                stack.push(node);
                visited.add(node);
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            } else {
                ret.add(node.val);
            }
        }
        return ret;
    }
}