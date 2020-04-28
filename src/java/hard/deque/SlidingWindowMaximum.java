package src.java.hard.deque;

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums==null || k<=0)    return null;
      
      int[] ret = new int[nums.length-k+1];
      Deque<Integer> dq = new LinkedList<>();
      
      int i = 0, cur = 0;
      for(; i<k; i++) {
          while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
              dq.removeLast();
          dq.addLast(i);
      }
      ret[cur++] = nums[dq.peekFirst()];
      
      for(; i<nums.length; i++) {
          while(!dq.isEmpty() && dq.peekFirst()<=i-k)
              dq.removeFirst();
          while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
              dq.removeLast();
          dq.addLast(i);
          ret[cur++] = nums[dq.peekFirst()];
      }
      
      return ret;
  }
}