package src.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums==null || nums.length<4)  return ret;
        
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-3; i++){
            if (i>0 && nums[i-1]==nums[i])    continue;
            for (int j=i+1; j<nums.length-2; j++){
                if (j>i+1 && nums[j-1]==nums[j])  continue;
                int sum1 = nums[i]+nums[j];
                int n = target-sum1;
                int s=j+1, t=nums.length-1;
                while(s < t){
                    int sum2 = nums[s] + nums[t]; 
                    if (sum2 < n)    s++;
                    else if (sum2 > n)  t--;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[s++]);
                        list.add(nums[t--]);
                        ret.add(list);
                        while (nums[s]==nums[s-1] && s<t)   s++;
                        while (nums[t]==nums[t+1] && s<t)   t--;
                    }
                }
            }
        }
        return ret;
    }
}

