package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        combine(n, k, 1, list, ret);
        return ret;
    }
    
    private void combine(int n, int k, int start, List<Integer> list, List<List<Integer>> ret) {
        if (k == 0) {
            List<Integer> l = new ArrayList<>(list);
            ret.add(l);
            return;
        }
        
        for (int i=start; i<=n-k+1; i++) {
            list.add(i);
            combine(n, k-1, i+1, list, ret);
            list.remove(list.size()-1);
        }
    }
    
    // Legacy
    public ArrayList<ArrayList<Integer>> combine2(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (n<k)    return ret;
        if(k==1){
            for(int i=1; i<=n; i++){
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                ret.add(l);
            }
            return ret;
        }
        
        for(int i=n; i>=k; i--){
            ArrayList<ArrayList<Integer>> list = combine2(i-1, k-1);
            for(ArrayList<Integer> t : list)
                t.add(i);
            ret.addAll(list);
        }
        
        return ret;
    }
}

