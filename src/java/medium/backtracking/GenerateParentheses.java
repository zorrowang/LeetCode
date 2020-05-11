package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        dfs(n, 0, 0, ret, "");
        return ret;
    }
    
    private void dfs(int n, int left, int right, List<String> ret, String str) {
        if (right > left || left > n || right > n)   return;
        if (right == n && left == n) {
            ret.add(str);
            return;
        }
        dfs(n, left+1, right, ret, str+"(");
        dfs(n, left, right+1, ret, str+")");
    }
}

