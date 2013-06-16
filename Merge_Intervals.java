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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if (intervals==null || intervals.size()==0) return ret;
        
        Interval[] array = intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort(array, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start>i2.start?1:(i1.start==i2.start?0:-1);
            }
        });
        
        Interval in = array[0];
        int i=1;
        while(i<array.length){
            if (isOverLap(in, array[i]))
                in = merge(in, array[i++]);
            else{
                ret.add(in);
                in = array[i++];
            }
        }
        ret.add(in);
        return ret;
    }
    
    public boolean isOverLap(Interval i, Interval t){
        return !(i.start>t.end||t.start>i.end);
    }
    
    public Interval merge(Interval i, Interval t){
        return new Interval(Math.min(i.start, t.start), Math.max(i.end, t.end));
    }
}

