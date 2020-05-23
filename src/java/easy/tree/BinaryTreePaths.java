package src.java.easy.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dfs(root, new ArrayList<>(), ret);
        return ret;
    }
    
    private void dfs(TreeNode root, List<String> path, List<String> ret) {
        if (root == null)   return;
        if (root.left == null && root.right ==null) {
            path.add(String.valueOf(root.val));
            ret.add(String.join("->", path));
            path.remove(path.size()-1);
            return;
        }
        path.add(String.valueOf(root.val));
        if (root.left != null)  dfs(root.left, path, ret);
        if (root.right != null)  dfs(root.right, path, ret);
        path.remove(path.size()-1);
    }
}