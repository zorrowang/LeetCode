package src.java.hard.heap;

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> smaller;
    private PriorityQueue<Integer> larger;

    /** initialize your data structure here. */
    public MedianFinder() {
        smaller = new PriorityQueue<>((i1, i2) -> i2-i1);
        larger = new PriorityQueue<>((i1, i2) -> i1-i2);
    }
    
    public void addNum(int num) {
        if (!smaller.isEmpty() && num <= smaller.peek())
            smaller.offer(num);
        else 
            larger.offer(num);
        
        if (smaller.size() - larger.size() > 1)
            larger.offer(smaller.poll());
        else if (smaller.size() - larger.size() < -1)
            smaller.offer(larger.poll());
    }
    
    public double findMedian() {
        if (smaller.isEmpty() && larger.isEmpty())
            return 0;
        else if (smaller.isEmpty())
            return larger.peek();
        else if (larger.isEmpty())
            return smaller.peek();
        else {
            if (smaller.size() == larger.size())
                return ((double)(larger.peek()+smaller.peek()))/2;
            else if (smaller.size() > larger.size())
                return smaller.peek();
            else
                return larger.peek();
        }
    }
}