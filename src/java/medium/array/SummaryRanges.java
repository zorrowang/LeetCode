package src.java.medium.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums==null || nums.length==0)   return ret;
        int i=0, j=1;
        while(j<nums.length) {
            if (nums[j]!=nums[j-1]+1) {
                ret.add(build(nums[i], nums[j-1]));
                i = j;
            }
            j++;
        }
        ret.add(build(nums[i], nums[j-1]));
        return ret;
    }
    
    private String build(int i, int j) {
        if (i==j)   return String.valueOf(i);
        else    return i+"->"+j;
    }
}