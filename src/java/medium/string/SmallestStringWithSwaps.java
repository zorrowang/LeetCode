package src.java.medium.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {
    public int[] parent;
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s==null || s.length()==0)   return s;
        int len = s.length();
        parent = new int[len];
        for (int i=0; i<len; i++)
            parent[i] = i;
        for (int i=0; i<pairs.size(); i++)
            union(s, pairs.get(i).get(0), pairs.get(i).get(1));
        
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i=0; i<len; i++) {
            int p = find(i);
            map.putIfAbsent(p, new PriorityQueue<Character>());
            map.get(p).offer(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++)
            sb.append(map.get(find(i)).poll());
        return sb.toString();
    }
    
    private int find(int i) {
        while (i != parent[i])
            i = parent[i];
        return i;
    }
    
    private void union(String s, int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (s.charAt(pi) < s.charAt(pj))
            parent[pj] = pi;
        else
            parent[pi] = pj;
    }
}