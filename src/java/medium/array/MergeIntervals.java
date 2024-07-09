package src.java.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MergeIntervals {
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        boolean isOverlapping(Interval i) {
            if (this.start > i.end || i.start > this.end)
                return false;
            return true;
        }
        
        void merge(Interval i) {
            start = Math.min(start, i.start);
            end = Math.max(end, i.end);
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i=0; i<intervals.length; i++)
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        Collections.sort(list, (i1, i2) -> i1.start==i2.start ? i1.end-i2.end : i1.start-i2.start);
        List<Interval> merged = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            Interval in = list.get(i);
            if (merged.isEmpty() || !merged.get(merged.size()-1).isOverlapping(in))
                merged.add(in);
            else
                merged.get(merged.size()-1).merge(in);
        }
        int[][] ret = new int[merged.size()][2];
        for (int i=0; i<merged.size(); i++) {
            ret[i][0] = merged.get(i).start;
            ret[i][1] = merged.get(i).end;
        }
        return ret;
    }

    // Not create a new obj
    public int[][] merge2(int[][] intervals) {
        if (intervals == null)  return intervals;
        Arrays.sort(intervals, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        List<int[]> ret = new ArrayList<>();
        int[] cur = new int[]{intervals[0][0], intervals[0][1]};
        int i = 1;
        while (i < intervals.length) {
            if (intervals[i][0] <= cur[1]) {
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                ret.add(new int[]{cur[0], cur[1]});
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }
            i++;
        }
        ret.add(new int[]{cur[0], cur[1]});
        return ret.toArray(new int[ret.size()][]);
    }
}