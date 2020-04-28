package src.java.medium.array;

import java.util.Arrays;
import java.util.HashMap;

//Solution 1: sort
class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ret = 0;
        for (int i=0; i<citations.length; i++) {
            int c = citations[citations.length-i-1];
            if (c >= i+1) {
                ret = i+1;
            }
        }
        return ret;
    }
}

//Solution 2: map
class HIndex2 {
    public int hIndex(int[] citations) {
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<citations.length; i++) {
            int c = citations[i];
            if (c >= citations.length)
                map.put(citations.length, map.getOrDefault(citations.length, 0)+1);
            else if (c > 0)
                map.put(c, map.getOrDefault(c, 0)+1);
        }
        int count = 0;
        for (int i=citations.length; i>0; i--) {
            if (map.containsKey(i)) {
                count += map.get(i);
                if (count >= i)
                    ret = Math.max(ret, i);
                else
                    ret = Math.max(ret, count);
            }
        }
        return ret;
    }
}