package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        return dfs(start, end, new HashSet<>(Arrays.asList(bank)), new HashSet<>(), 0);
    }
    
    private int dfs(String start, String end, Set<String> bank, Set<String> used, int len) {
        if (start.equals(end))  return len;
        if (bank.size() == used.size()) return -1;
        
        int ret = Integer.MAX_VALUE;
        for (int i=0; i<start.length(); i++) {
            List<String> nexts = mutate(start, i);
            for (int j=0; j<nexts.size(); j++) {
                String s = nexts.get(j);
                if (!bank.contains(s) || used.contains(s)) continue;
                used.add(s);
                int t = dfs(s, end, bank, used, len+1);
                used.remove(s);
                if (t == -1)    continue;
                ret = Math.min(t, ret);
            }
        }
        return ret==Integer.MAX_VALUE ? -1 : ret;
    }
    
    private List<String> mutate(String s, int pos) {
        char[] genes = {'A', 'C', 'G', 'T'};
        List<String> ret = new ArrayList<>();
        char[] array = s.toCharArray();
        char c = array[pos];
        for (int i=0; i<genes.length; i++) {
            if (c == genes[i])  continue;
            array[pos] = genes[i];
            ret.add(String.valueOf(array));
        }
        return ret;
    }
}