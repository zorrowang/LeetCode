/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/**
 * The worse case of this solution is O(n^2)
 * Sort and binary search can do better to O(nlgn)
 **/
public class Solution {
    
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null) {
            return null;
        }
        int[] ret = new int[intervals.length];
        Interval[] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, new IntervalComparator());
        HashMap<Integer, Integer> sortedStartIndexMap = new HashMap<>();
        for (int i = 0; i < sortedIntervals.length; i++) {
            sortedStartIndexMap.put(sortedIntervals[i].start, i);
        }
        HashMap<Integer, Integer> sortedIndexToOriginIndexMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            sortedIndexToOriginIndexMap.put(sortedStartIndexMap.get(intervals[i].start), i);
        }
        for (int i = sortedIntervals.length - 1; i >= 0; i--) {
            if (i == sortedIntervals.length - 1) {
                ret[sortedIndexToOriginIndexMap.get(i)] = -1;
            } else {
                int j = i+1;
                while (j < sortedIntervals.length - 1 && sortedIntervals[i].end > sortedIntervals[j].start) {
                    j++;
                }
                if (j == sortedIntervals.length - 1 && sortedIntervals[i].end > sortedIntervals[j].start) {
                    ret[sortedIndexToOriginIndexMap.get(i)] = -1;
                } else {
                    ret[sortedIndexToOriginIndexMap.get(i)] = sortedIndexToOriginIndexMap.get(j);
                }
            }
        }
        
        return ret;
    }
}