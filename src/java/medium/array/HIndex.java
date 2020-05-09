package src.java.medium.array;

import java.util.Arrays;
import java.util.HashMap;

class HIndex {
    // Time: O(n)
    // Space: O(n)
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0)
            return 0;
        int len = citations.length;
        int[] counts = new int[len+1];
        for (int i=0; i<len; i++) {
            if (citations[i]>len)   counts[len]++;
            else    counts[citations[i]]++;
        }

        for (int i=len-1; i>=0; i--) {
            counts[i] += counts[i+1];
        }
        int ret = 0;
        for (int i=1; i<=len; i++) {
            if (counts[i]>=i)   ret = i;
        }
        return ret;
    }

    // Time: O(n)
    // Space: O(n)
    public int hIndex2(int[] citations) {
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

    // Time: O(nlogn)
    // Space: O(1)
    public int hIndex3(int[] citations) {
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