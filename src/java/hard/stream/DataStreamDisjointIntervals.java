package src.java.hard.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Binary Search
class SummaryRanges {
    List<Integer[]> intervals;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        intervals = new ArrayList<>();
    }
    
    public void addNum(int val) {
        if (intervals.isEmpty()) {
            intervals.add(new Integer[]{val, val});
            return;
        }
        // binary search and insert
        int lo = 0, hi = intervals.size()-1;
        int mid = 0;
        while (lo <= hi) {
            if (lo == hi) {
                if (val >= intervals.get(lo)[0] && val <= intervals.get(lo)[1])   break;
                else if (intervals.get(lo)[0]-1 == val) {
                    intervals.get(lo)[0] = val;
                    if (lo > 0 && intervals.get(lo-1)[1] == val-1) {
                        intervals.set(lo, merge(intervals.get(lo-1), intervals.get(lo)));
                        intervals.remove(lo-1);
                    } 
                }
                else if (intervals.get(lo)[1]+1 == val) {
                    intervals.get(lo)[1] = val;
                    if (lo < intervals.size()-1 && intervals.get(lo+1)[0] == val+1) {
                        intervals.set(lo, merge(intervals.get(lo+1), intervals.get(lo)));
                        intervals.remove(lo+1);
                    } 
                }
                else if (intervals.get(lo)[0] > val) {
                    intervals.add(lo, new Integer[]{val, val});
                    if (lo > 0 && intervals.get(lo-1)[1] == val-1) {
                        intervals.set(lo, merge(intervals.get(lo-1), intervals.get(lo)));
                        intervals.remove(lo-1);
                    }
                }
                else {
                    intervals.add(lo+1, new Integer[]{val, val});
                    if (lo+1 < intervals.size()-1 && intervals.get(lo+2)[0] == val+1) {
                        intervals.set(lo+1, merge(intervals.get(lo+1), intervals.get(lo+2)));
                        intervals.remove(lo+2);
                    }
                }
                break;
            }
            mid = lo + (hi - lo)/2;
            Integer[] in = intervals.get(mid);
            if (val >= in[0] && val <= in[1])   break;
            else if (val < in[0])   hi = mid-1<lo?lo:mid-1;
            else                    lo = mid+1>hi?hi:mid+1;
        } 
    }
    
    private Integer[] merge(Integer[] in1, Integer[] in2) {
        return new Integer[]{Math.min(in1[0], in2[0]), Math.max(in1[1], in2[1])};
    }
    
    public int[][] getIntervals() {
        int[][] ret = new int[intervals.size()][2];
        for (int i=0; i<intervals.size(); i++) {
            ret[i][0] = intervals.get(i)[0];
            ret[i][1] = intervals.get(i)[1];
        }
        return ret;
    }
}


// Union Find
class SummaryRanges2 {
    Map<Integer, Integer> map;
    Map<Integer, Integer> intervals;

    /** Initialize your data structure here. */
    public SummaryRanges2() {
        map = new HashMap<>();
        intervals = new HashMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val))   return;
        map.put(val, 1);
        if (map.containsKey(val-1) && map.containsKey(val+1)) {
            int left = map.get(val-1), right = map.get(val+1);
            map.put(val-left, left+right+1);
            map.put(val+right, left+right+1);
            intervals.put(val-left, val+right);
            intervals.remove(val+1);
        } else if (map.containsKey(val-1)) {
            int left = map.get(val-1);
            map.put(val, left+1);
            map.put(val-left, left+1);
            intervals.put(val-left, val);
        } else if (map.containsKey(val+1)) {
            int right = map.get(val+1);
            map.put(val, right+1);
            map.put(val+right, right+1);
            intervals.put(val, val+right);
            intervals.remove(val+1);
        } else
            intervals.put(val, val);
    }
    
    public int[][] getIntervals() {
        int[][] ret = new int[intervals.size()][2];
        int i = 0;
        for (Integer s : intervals.keySet()) {
            ret[i][0] = s;
            ret[i++][1] = intervals.get(s);
        }
        // This sorting is only for passing OJ.
        Arrays.sort(ret, (i1, i2) -> i1[0] - i2[0]);
        return ret;
    }
}