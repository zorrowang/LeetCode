package src.java.medium.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> ret = new ArrayList<>();
        int i=0;
        for (; i<nums.length&&nums[i]<=upper; i++) {
            if (lower > nums[i]) {
                continue;
            } else if (lower < nums[i]) {
                if (lower == nums[i]-1) {
                    ret.add(String.valueOf(lower));
                } else {
                    ret.add(String.valueOf(lower)+"->"+String.valueOf(nums[i]-1));
                }
            }
            if (nums[i] == Integer.MAX_VALUE)   return ret;
            lower = nums[i]+1;
        }
        
        if(lower < upper) {
            if (lower == upper-1) {
                ret.add(String.valueOf(lower));
            } else {
                ret.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            }
        } else if (lower == upper) {
            ret.add(String.valueOf(lower));
        }
        
        return ret;
    }
}