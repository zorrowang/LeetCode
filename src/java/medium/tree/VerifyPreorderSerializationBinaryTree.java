package src.java.medium.tree;

public class VerifyPreorderSerializationBinaryTree {
    int cur = 0;
    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        dfs(array);
        return cur==array.length-1;
    }
    
    private void dfs(String[] preorder) {
        if (cur>=preorder.length) return;
        if (preorder[cur].equals("#"))    return;
        cur++;
        dfs(preorder);
        cur++;
        dfs(preorder);
    }
}