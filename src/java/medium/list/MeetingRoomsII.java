package src.java.medium.list;

import java.util.Collections;
import java.util.List;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRoomsII {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals==null || intervals.isEmpty()) return 0;
        boolean[] roomChainEnd = new boolean[intervals.size()];
        roomChainEnd[0] = true;
        int ret = 1;
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i=1; i<intervals.size(); i++) {
            for (int j=i-1; j>=0; j--) {
                if (!roomChainEnd[j]) continue;
                if (intervals.get(j).end <= intervals.get(i).start) {
                    roomChainEnd[i] = true;
                    roomChainEnd[j] = false;
                    break;
                }
            }
            if (!roomChainEnd[i]) {
                roomChainEnd[i] = true;
                ret++;
            }
        }
        return ret;
    }
}