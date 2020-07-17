package src.java.medium.greedy;

import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> p1[1]==p2[1]?p1[0]-p2[0]:p1[1]-p2[1]);
        int cnt = 0, i = 0;
        while (i < points.length) {
            int end = points[i][1];
            int j = i+1;
            while (j < points.length && points[j][0] <= end && points[j][1] >= end)
                j++;
            i = j;
            cnt++;
        }
        return cnt;
    }
}