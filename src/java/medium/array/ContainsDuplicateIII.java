package src.java.medium.array;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 0 || t < 0) return false;
        Map<Long, Integer> map = new TreeMap<>();
        for (int i=0; i<nums.length; i++) {
            if (i > k) {
                int cnt = map.get((long)nums[i-k-1]) - 1;
                if (cnt == 0)   map.remove((long)nums[i-k-1]);
                else    map.put((long)nums[i-k-1], cnt);
                
            }
            if (map.containsKey((long)nums[i]))   return true;
            map.put((long)nums[i], 1);
            if (check(map, t))  return true;
        }
        return false;
    }
    
    private boolean check(Map<Long, Integer> map, int t) {
        Set<Long> c = map.keySet();
        Iterator<Long> itr = c.iterator();
        Long prev = 0L, cur = 0L;
        if (itr.hasNext())  
            prev = itr.next();
        while(itr.hasNext()) {
            cur = itr.next();
            if (cur - prev <= t)    return true;
            prev = cur;
        }
        return false;
    }
}