/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
		    return i1.start - i2.start;
	    }
    }
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new IntervalComparator());
        LinkedList<Interval> ret = new LinkedList<>();
        ret.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval pre = ret.peek();
            if (isOverlapping(pre, intervals[i])) {
                if (pre.end >= intervals[i].end) {
                    ret.pop();
                    ret.push(intervals[i]);
                }
            } else {
                ret.push(intervals[i]);
            }
        }
        return intervals.length - ret.size();
    }
    
    private boolean isOverlapping(Interval i1, Interval i2) {
        return (i1.start <= i2.start && i1.end > i2.start);
    }
}