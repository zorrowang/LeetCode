/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int[] ret = sumOfLeftLeavesHelper(root);
        return ret[0];
    }
    
    public int[] sumOfLeftLeavesHelper(TreeNode root) {
        int[] ret = new int[2];
        if (root == null) {
            return ret;
        }
        if (root.left == null && root.right == null) {
            ret[0] = root.val;
            ret[1] = 1;
            return ret;
        } else if (root.left == null) {
            int[] right = sumOfLeftLeavesHelper(root.right);
            if (right[1] == 1) {
                right[0] = 0;
            }
            right[1] = 0;
            return right;
        } else if (root.right == null) {
            int[] left = sumOfLeftLeavesHelper(root.left);
            left[1] = 0;
            return left;
        } else {
            int[] right = sumOfLeftLeavesHelper(root.right);
            int[] left = sumOfLeftLeavesHelper(root.left);
            ret[0] = left[0];
            if (right[1] == 0) {
                ret[0] += right[0];
            }
            ret[1] = 0;
            return ret;
        }
        // return ret;
    }
}