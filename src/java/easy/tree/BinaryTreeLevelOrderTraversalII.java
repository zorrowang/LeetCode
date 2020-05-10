package src.java.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreeLevelOrderTraversalII {
    // DFS
    int height = 1;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, ret, 1);
        return ret;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> ret, int level) {
        if(root==null)  return;
        height = Math.max(level, height);
        if (ret.size() < level) ret.add(0, new ArrayList<>());
        ret.get(height-level).add(root.val);
        dfs(root.left, ret, level+1);
        dfs(root.right, ret, level+1);
    }

    // BFS
    public List<List<Integer>> levelOrderBottomBfs(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root==null) return ret;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
        queue.offer(root);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null)    temp.offer(node.left);
            if (node.right!=null)   temp.offer(node.right);
            if (queue.isEmpty() && !temp.isEmpty()){
                queue = temp;
                temp = new LinkedList<TreeNode>();
                ret.add(0, list);
                list = new ArrayList<Integer>();
            }
        }
        
        ret.add(0, list);
        return ret;
    }
}