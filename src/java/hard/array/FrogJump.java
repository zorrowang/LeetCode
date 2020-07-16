package src.java.hard.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i<stones.length; i++)
            map.put(stones[i], new HashSet<>());
        
        int[] pos = {-1, 0, 1};
        for (int i=0; i<stones.length; i++) {
            if (i==0) {
                int next = stones[0] + 1;
                if (map.containsKey(next))  map.get(next).add(1);
                else    return false;
            } else {
                Set<Integer> jumps = map.get(stones[i]);
                if (jumps.isEmpty())    return false;
                for (Integer j : jumps) {
                    for (int s=0; s<3; s++) {
                        int next = j + pos[s];
                        if (next <= 0)  continue;
                        else if (next + stones[i] == stones[stones.length-1])    
                            return true;
                        else if (map.containsKey(next + stones[i]))  
                            map.get(next + stones[i]).add(next);
                    }
                }
            }
        }
        return true;
    }

    // Backtracking - TLE
    public boolean canCross2(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<stones.length; i++)
            map.put(stones[i], i);
        return dfs(stones, 0, 1, map);
    }
    
    private boolean dfs(int[] stones, int pos, int jump, Map<Integer, Integer> map) {
        int p = pos + jump;
        if (!map.containsKey(p))    return false;
        int index = map.get(p);
        if (index == stones.length-1)   return true;
        return dfs(stones, p, jump, map) || dfs(stones, p, jump+1, map) || 
               (jump>1 && dfs(stones, p, jump-1, map));
    }
}