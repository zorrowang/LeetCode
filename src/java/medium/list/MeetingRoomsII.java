package src.java.medium.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
     * Line Sweep Algorithm
     * Time complexity: O(nlogn)
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) return 0;
        int[][] points = new int[intervals.size()*2][2];
        for (int i=0; i<intervals.size(); i++) {
            points[i][0] = intervals.get(i).start;
            points[i][1] = i;
            points[intervals.size() + i][0] = intervals.get(i).end;
            points[intervals.size() + i][1] = i;
        }
        Arrays.sort(points, (o1, o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
        Set<Integer> set = new HashSet<>();
        int ret = 0;
        for (int i=0; i<points.length; i++) {
            if (set.contains(points[i][1])) set.remove(points[i][1]);
            else    set.add(points[i][1]);
            ret = Math.max(ret, set.size());
        }
        return ret;
    }

    public int minMeetingRooms2(List<Interval> intervals) {
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