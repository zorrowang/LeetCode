package src.medium.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums==null || nums.length==0)
            return ret;
        
        int num1 = nums[0], count1=0;
        int num2 = nums[0], count2=0;
        for(int i=0; i<nums.length; i++) {
            if (num1 == nums[i])
                count1++;
            else if (num2 == nums[i])
                count2++;
            else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int i=0; i<nums.length; i++) {
            if (num1 == nums[i])
                count1++;
            else if (num2 == nums[i])
                count2++;
        }
        
        
        if (count1 > nums.length/3)
            ret.add(num1);
        if (count2 > nums.length/3)
            ret.add(num2);
        return ret;
    }
}