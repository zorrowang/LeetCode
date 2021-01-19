package src.java.easy.dp;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)  return Integer.MIN_VALUE;
        
        int maxSofar=nums[0], maxEndingHere=nums[0];
        
        for(int i=1; i<nums.length; i++){
            maxEndingHere = Math.max(nums[i], maxEndingHere+nums[i]);
            maxSofar = Math.max(maxEndingHere, maxSofar);
        }
        
        return maxSofar;
    }
}