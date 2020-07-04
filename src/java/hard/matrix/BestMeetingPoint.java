package src.java.hard.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    /**
     * Find the median value on x-axis and y-axis
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        int m = grid.length, n = grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        int ret = 0;
        for (int i : rows)
            ret += Math.abs(i - rows.get(rows.size()/2));
        Collections.sort(cols);
        for (int i : cols)
            ret += Math.abs(i - cols.get(cols.size()/2));
        return ret;
    }
}