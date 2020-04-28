package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        combinationSum3(k, n, 1, list, ret);
        return ret;
    }
    
    private void combinationSum3(int k, int n, int start, List<Integer> list, List<List<Integer>> ret) {
        if (n == 0 && k == 0) {
            ret.add(new ArrayList<>(list));
            return;
        } else if (k <= 0 || k+start > 10)
            return;
        
        for (int i=start; i<=10-k; i++) {
            list.add(i);
            combinationSum3(k-1, n-i, i+1, list, ret);
            list.remove(list.size()-1);
        }
    }
}