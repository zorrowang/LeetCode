package src.java.hard.array;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CountSmallerNumbersAfterSelf {
    // TLE
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if (nums==null || nums.length==0)   return ret;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2-i1);
        pq.offer(nums[nums.length-1]);
        ret.add(0);
        for (int i=nums.length-2; i>=0; i--) {
            PriorityQueue<Integer> t = new PriorityQueue<>(pq);
            while(!t.isEmpty() && t.peek() >= nums[i])
                t.poll();
            ret.add(0, t.size());
            pq.offer(nums[i]);
        }
        return ret;
    }
}