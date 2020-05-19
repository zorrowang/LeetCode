package src.java.medium.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class NonOverlappingIntervals {
    // 1D DP solution
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals==null || intervals.length==0) return 0;
        List<Interval> list = new ArrayList<>();
        for (int i=0; i<intervals.length; i++)
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        Collections.sort(list, (i1, i2) -> (i1.start==i2.start ? i1.end-i2.end : i1.start-i2.start));
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i=1; i<list.size(); i++) {
            for (int j=i-1; j>=0; j--) {
                if (isNotOverLapping(list.get(i), list.get(j)))
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        return intervals.length - max;
    }
    
    private boolean isNotOverLapping(Interval i1, Interval i2) {
        return i1.start >= i2.end || i2.start >= i1.end;
    }
    // Legacy question and solution
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