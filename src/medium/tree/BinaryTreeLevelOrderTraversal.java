package src.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    // DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, ret, 0);
        return ret;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> ret, int level) {
        if (root == null)  
            return;
        if (level > ret.size()-1) {
            ret.add(new ArrayList<>(Arrays.asList(root.val)));
        } else {
            ret.get(level).add(root.val);
        }
        dfs(root.left, ret, level+1);
        dfs(root.right, ret, level+1);
    }

    // BFS
    public List<List<Integer>> levelOrderBfs(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root==null) return ret;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
        queue.offer(root);
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null)    temp.offer(node.left);
            if (node.right!=null)   temp.offer(node.right);
            if (queue.isEmpty() && !temp.isEmpty()){
                queue = temp;
                temp = new LinkedList<>();
                ret.add(list);
                list = new ArrayList<>();
            }
        }
        
        ret.add(list);
        return ret;
    }
}