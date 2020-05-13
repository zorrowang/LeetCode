package src.java.easy.tree;

import java.util.LinkedList;

public class MinimumAbsoluteDifference {
    public int getMinimumDifference(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int pre = -1;
        int ret = Integer.MAX_VALUE;
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        
        while(!stack.isEmpty()) {
            cur = stack.pop();
            if (pre < 0)   pre = cur.val;
            else {
                ret = Math.min(cur.val - pre, ret);
                pre = cur.val;
            }
            if (cur.right != null) {
                cur = cur.right;
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return ret;
    }
}