package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i=1; i<=9; i++)
            dfs(n, i, ret);
        return ret;
    }
    
    private void dfs(int n, int cur, List<Integer> ret) {
        if (n < cur)    return;
        ret.add(cur);
        for (int i=0; i<10; i++)
            dfs(n, cur*10+i, ret);
    }
}