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

