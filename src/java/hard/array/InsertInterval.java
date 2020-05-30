package src.java.hard.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> ret = new ArrayList<>();
        List<Interval> list = new ArrayList<>();
        for (int i=0; i<intervals.length; i++)
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        Collections.sort(list, (i1, i2) -> i1.start==i2.start?i1.end-i2.end:i1.start-i2.start);
        Interval interval = new Interval(newInterval[0], newInterval[1]);
        
        for(int i=0; i<list.size(); i++){
            if(isOverLap(list.get(i), interval))
                interval=merge(interval, list.get(i));
            else
                ret.add(list.get(i));
        }
        
        int[][] matrix = new int[ret.size()+1][2];
        int j = 0;
        for (int i=0; i<ret.size(); i++) {
            if(interval != null && interval.start < ret.get(i).start) {
                matrix[j][0] = interval.start;
                matrix[j++][1] = interval.end;
                interval = null;
            }
            matrix[j][0] = ret.get(i).start;
            matrix[j++][1] = ret.get(i).end;
        }
        if (interval != null) {
            matrix[ret.size()][0] = interval.start;
            matrix[ret.size()][1] = interval.end;
        }
        return matrix;
    }

    // Legacy Solution
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> ret = new ArrayList<Interval>();
        
        for(int i=0; i<intervals.size(); i++){
            if(isOverLap(intervals.get(i), newInterval))
                newInterval=merge(newInterval, intervals.get(i));
            else
                ret.add(intervals.get(i));
        }
        
        int i=0;
        while(i<ret.size()){
            if(newInterval.start<ret.get(i).start)                
                break;
            i++;
        }
        ret.add(i, newInterval);
        return ret;
    }
    
    public boolean isOverLap(Interval i, Interval t){
        return !(i.start>t.end||t.start>i.end);
    }
    
    public Interval merge(Interval i, Interval t){
        return new Interval(Math.min(i.start, t.start), Math.max(i.end, t.end));
    }
}

