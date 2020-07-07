package src.java.hard.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        int len = nums.length;
        double[] ret = new double[len-k+1];
        
        for (int i=0; i<len; i++) {
            if (i >= k)
                remove(nums[i-k], minHeap, maxHeap);
            add(nums[i], minHeap, maxHeap);
            if (i >= k-1)
                ret[i-k+1] = getMedian(minHeap, maxHeap);
        }
        return ret;
    }
    
    private void add(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.isEmpty() && maxHeap.isEmpty())  minHeap.offer(n);
        else if ((double)n >= getMedian(minHeap, maxHeap))   minHeap.offer(n);
        else                                    maxHeap.offer(n);
        while (minHeap.size() - 1 > maxHeap.size())   maxHeap.offer(minHeap.poll());
        while (maxHeap.size() - 1 > minHeap.size())   minHeap.offer(maxHeap.poll());
    }
    
    private void remove(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.contains(n))    minHeap.remove(n);
        else                        maxHeap.remove(n);
        while (minHeap.size() - 1 > maxHeap.size())   maxHeap.offer(minHeap.poll());
        while (maxHeap.size() - 1 > minHeap.size())   minHeap.offer(maxHeap.poll());
    }
    
    private double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) return 0;
        else if (minHeap.isEmpty() || maxHeap.size() > minHeap.size())  return (double)(maxHeap.peek());
        else if (maxHeap.isEmpty() || minHeap.size() > maxHeap.size())  return (double)(minHeap.peek());
        else    return ((double)(minHeap.peek()) + (double)(maxHeap.peek()))/2;
    }
}