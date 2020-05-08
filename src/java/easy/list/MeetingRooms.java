package src.java.easy.list;

import java.util.Collections;
import java.util.List;


class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class MeetingRooms {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i=1; i<intervals.size(); i++) {
            if (intervals.get(i-1).end > intervals.get(i).start)
                return false;
        }
        return true;
    }
}