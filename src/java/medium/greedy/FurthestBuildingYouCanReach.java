package java.medium.greedy;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] diffs = new int[heights.length-1];
        for (int i=0; i<heights.length-1; i++)
            diffs[i] = heights[i+1]>heights[i] ? heights[i+1]-heights[i] : 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        int sum = 0, cnt = 0;
        for (int i=0; i<diffs.length; i++) {
            sum += diffs[i];
            pq.offer(diffs[i]);
            if (sum > bricks) {
                sum -= pq.poll();
                ladders--;
            }
            if (sum > bricks || ladders < 0)   break;
            cnt++;
        }
        return cnt;
    }
}
