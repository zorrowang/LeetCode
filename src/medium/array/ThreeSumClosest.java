package src.medium.array;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
      if (nums==null || nums.length<3)  return Integer.MAX_VALUE;
        
      Arrays.sort(nums);
      int ret = nums[0]+nums[1]+nums[num.length-1];
      
      for (int i=0; i<nums.length-2; i++){
          int j=i+1, k=nums.length-1;
          while(j<k){
              int temp = nums[i]+nums[j]+nums[k];
              if (temp<target){
                  ret = Math.abs(temp-target)<Math.abs(ret-target)?temp:ret;
                  j++;
              }
              else if (temp>target){
                  ret = Math.abs(temp-target)<Math.abs(ret-target)?temp:ret;
                  k--;
              }
              else
                  return target;
          }
      }
      
      return ret;
    }
}