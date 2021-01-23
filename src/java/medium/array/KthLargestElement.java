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

    // QuickSelect solution
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    private int quickSelect(int[] nums, int lo, int hi, int k) {
        int pivot = lo;
        for (int i=lo; i<hi; i++) {
            if (nums[i] <= nums[hi])
                swap(nums, pivot++, i);
        }
        swap(nums, pivot, hi);
        
        int cnt = hi - pivot + 1;
        if (cnt < k)    return quickSelect(nums, lo, pivot-1, k-cnt);
        else if (cnt > k)   return quickSelect(nums, pivot+1, hi, k);
        else return nums[pivot];
    }
    
    private void swap(int[]nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}