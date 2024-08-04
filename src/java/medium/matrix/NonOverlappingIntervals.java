package src.java.medium.matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class NonOverlappingIntervals {
    // Greedy solution
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int prev = 0, cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                cnt++;
            }
        }
        return intervals.length - cnt;
    }

    // 1D DP solution
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            int j = i-1;
            while (j >= 0 && intervals[i][0] < intervals[j][1])
                j--;
            if (j == -1)    dp[i] = 1;
            else            dp[i] = dp[j]+1;
        }
        return n - dp[n-1];
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