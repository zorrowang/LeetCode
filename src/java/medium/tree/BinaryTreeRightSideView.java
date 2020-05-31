package src.java.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.java.lib.TreeNode;

public class BinaryTreeRightSideView {
    // DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret, 1);
        return ret;
    }
    
    public void dfs(TreeNode root, List<Integer> ret, int level) {
        if (root == null)   return;
        if (ret.size() < level) ret.add(root.val);
        dfs(root.right, ret, level+1);
        dfs(root.left, ret, level+1);
    }

    // BFS
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)   return ret;
        Queue<TreeNode> q=new LinkedList<>(), t=new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if (flag) {
                ret.add(n.val);
                flag = false;
            }
            if (n.right!=null)  t.offer(n.right);
            if (n.left!=null)   t.offer(n.left);
            if (q.isEmpty() && !t.isEmpty()) {
                q = t;
                t = new LinkedList<>();
                flag = true;
            }
        }
        return ret;
    }
}