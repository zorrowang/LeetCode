package src.java.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> (a1[0] - a2[0]));
        for (Integer i : map.keySet()) {
            pq.offer(new int[]{map.get(i), i});
            if (pq.size() > k)  pq.poll();
        }
        for (int i=0; i<k; i++) ret[i] = pq.poll()[1];
        return ret;
    }
}