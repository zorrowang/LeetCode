package src.java.medium.bit;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] ret = new int[32];
        int num = 0;
        for(int i=31; i>=0; i--){
            for(int j=0; j<nums.length; j++){
                if (((nums[j]>>i)&1) == 1){
                    ret[i]++;
                }
            }
            ret[i] %= 3;
            num <<= 1;
            num = num|ret[i];
        }
        return num;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            sum += nums[i];
        }
        
        if(set.size()==1)
            return nums[0];
        for(Integer i: set)
            sum -= (((long)i)*3);
        return (int)(0-sum/2);
    }
}