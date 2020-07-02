package src.java.medium.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    // TreeMap
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = intervals.length;
        int[] ret = new int[len];
        for (int i=0; i<len; i++)
            map.put(intervals[i][0], i);
        for (int i=0; i<len; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            if (entry == null)  ret[i] = -1;
            else                ret[i] = entry.getValue();
        }
        return ret;
    }

    // Binary search solution
    public int[] findRightInterval2(int[][] intervals) {
        Map<Integer, Integer> startToIndex = new HashMap<>();
        int len = intervals.length;
        int[] ret = new int[len];
        int[] starts = new int[len];
        for (int i=0; i<len; i++) {
            starts[i] = intervals[i][0];
            startToIndex.put(intervals[i][0], i);
        }
        Arrays.sort(starts);
        for (int i=0; i<len; i++) {
            int s = binarySearch(starts, intervals[i][1]);
            if (s == -1)    ret[i] = -1;
            else            ret[i] = startToIndex.get(s);
        }
        return ret;
    }
    
    private int binarySearch(int[] nums, int t) {
        int lo = 0, hi = nums.length-1;
        int mid = -1;
        while(lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (nums[mid] == t)         return nums[mid];
            else if (nums[mid] < t)     lo = mid+1;
            else {
                if (mid > 0 && nums[mid-1] < t)
                    return nums[mid];
                else
                    hi = mid-1;
            }
        }
        return -1;
    }
}