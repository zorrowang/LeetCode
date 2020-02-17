package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> nums = new HashSet<>();
        for (int i=0; i<to_delete.length; i++)
            nums.add(to_delete[i]);
        return delNodes(root, nums, null);
    }
    
    public List<TreeNode> delNodes(TreeNode root, HashSet<Integer> nums, TreeNode parent) {
        ArrayList<TreeNode> ret = new ArrayList<>();
        
        if (root == null)
            return ret;
        
        if (nums.contains(root.val)) {
            ret.addAll(delNodes(root.left, nums, null));
            ret.addAll(delNodes(root.right, nums, null));
            if (parent != null && parent.left == root)
                parent.left = null;
            else if (parent != null && parent.right == root)
                parent.right = null;
        } else {
            if (parent == null)
                ret.add(root);
            ret.addAll(delNodes(root.left, nums, root));
            ret.addAll(delNodes(root.right, nums, root));
        }
        
        return ret;
    }
}
