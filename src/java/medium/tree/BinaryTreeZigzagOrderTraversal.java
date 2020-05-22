package src.java.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import src.java.lib.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreeZigzagOrderTraversal {
    // DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (level%2 == 0)
                ret.get(level).add(root.val);
            else
                ret.get(level).add(0, root.val);
        }
        
        dfs(root.left, ret, level+1);
        dfs(root.right, ret, level+1);
    }

    // BFS
    public List<List<Integer>>  zigzagLevelOrderBFS(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<List<Integer>>  ret = new ArrayList<>();
        if (root==null) return ret;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        queue.offer(root);
        
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if (i%2==1) list.add(0, node.val);
            else list.add(node.val);
            
            if (node.left!=null)    temp.offer(node.left);
            if (node.right!=null)   temp.offer(node.right);
            if (queue.isEmpty() && !temp.isEmpty()){
                queue = temp;
                temp = new LinkedList<>();
                ret.add(list);
                list = new ArrayList<>();
                i++;
            }
        }
        
        ret.add(list);
        return ret;
    }
}