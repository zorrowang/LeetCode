package src.java.medium.greedy;

import java.util.PriorityQueue;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people==null || people.length==0 || people[0].length==0)
            return people;
        int[][] ret = new int[people.length][people[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a1, a2) -> a1[0]==a2[0] ? a1[1]-a2[1] : a1[0]-a2[0]
        );
        for (int i=0; i<people.length; i++) {
            pq.offer(people[i]);
            ret[i][0] = -1;
        }
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int pos = pair[1];
            int i = 0;
            while (pos > 0 || ret[i][0] != -1) {
                if (ret[i][0] == -1 || ret[i][0] == pair[0])
                    pos--;
                i++;
            }
            ret[i][0] = pair[0];
            ret[i][1] = pair[1];
        }
        return ret;
    }
}