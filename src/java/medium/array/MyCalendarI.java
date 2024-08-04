package src.java.medium.array;

import java.util.LinkedList;
import java.util.List;

public class MyCalendarI {
    class MyCalendar {
    List<int[]> cal;

    public MyCalendar() {
        cal = new LinkedList<>();    
    }
    
    public boolean book(int start, int end) {
        int i = 0;
        while (i < cal.size()) {
            int[] c = cal.get(i);
            if (!(start >= c[1] || end <= c[0]))
                return false;
            if (end <= c[0]) {
                cal.add(i, new int[]{start, end});
                return true;
            }
            i++;
        }
        cal.add(new int[]{start, end});
            return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
