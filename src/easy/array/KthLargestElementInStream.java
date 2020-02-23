package src.easy.array;

import java.util.PriorityQueue;

class KthLargest {
  PriorityQueue<Integer> minQueue;
  int k;
  
  public KthLargest(int k, int[] nums) {
      minQueue = new PriorityQueue<>((x, y) -> x-y);
      this.k = k;
      for (int i=0; i<nums.length; i++) {
          if (i < k)
              minQueue.offer(nums[i]);
          else if (minQueue.peek() < nums[i]) {
              minQueue.poll();
              minQueue.offer(nums[i]);
          }
      }
  }
  
  public int add(int val) {
      if (minQueue.size() < k)
          minQueue.offer(val);
      else if (minQueue.peek() < val) {
          minQueue.poll();
          minQueue.offer(val);
      }
      return minQueue.peek();
  }
}

/**
* Your KthLargest object will be instantiated and called as such:
* KthLargest obj = new KthLargest(k, nums);
* int param_1 = obj.add(val);
*/