package src.java.medium.array;

import java.util.PriorityQueue;

public class KthLargestElement {
    // Heap solution
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1-i2);
        for (int i=0; i<nums.length; i++) {
            if (pq.size()<k)    pq.offer(nums[i]);
            else if (pq.size()==k && pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}