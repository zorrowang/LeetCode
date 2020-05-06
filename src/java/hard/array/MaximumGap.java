package src.java.hard.array;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums==null || nums.length<2)
            return 0;
        int max=nums[0], min=nums[0];
        for (int i=1; i<nums.length; i++){
            if (max < nums[i])   max = nums[i];
            if (min > nums[i])   min = nums[i];
        }
        
        double interval = 1.0 * (max-min) / (nums.length-1);
        int[] maxForInterval = new int[nums.length-1];
        int[] minForInterval = new int[nums.length-1];
        Arrays.fill(minForInterval, Integer.MAX_VALUE);
        minForInterval[0] = min;
        maxForInterval[nums.length-2] = max;
        if (nums.length > 2){
            maxForInterval[0] = min;
            minForInterval[nums.length-2] = max;
        }
        
        for (int i=0; i<nums.length; i++){
            if (nums[i] == min || nums[i] == max)
                continue;
            int diff = nums[i]-min;
            int index = (int)(diff/interval);
            if (minForInterval[index] > nums[i]) 
                minForInterval[index] = nums[i];
            if (maxForInterval[index] < nums[i])
                maxForInterval[index] = nums[i];
        }
        
        int ret = 0;
        int preMax = 0; 
        for (int i=0; i<maxForInterval.length; i++){
            if (minForInterval[i] == Integer.MAX_VALUE) continue;
            ret = Math.max(maxForInterval[i] - minForInterval[i], ret);
            if (i > 0)
                ret = Math.max(minForInterval[i] - preMax, ret);
            preMax = maxForInterval[i];
        }
        return ret;
    }
}
