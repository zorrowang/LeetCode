package src.java.medium.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int ret = Integer.MAX_VALUE;
        List<Integer> nums = new ArrayList<>();
        for (String t : timePoints)
            nums.add(convert(t));
        Collections.sort(nums);
        for(int i=0; i<nums.size()-1; i++) {
            ret = Math.min(ret, nums.get(i+1)-nums.get(i));
        }
        return Math.min(ret, 24*60-nums.get(nums.size()-1)+nums.get(0));
    }
    
    private int convert(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0])*60 + Integer.parseInt(hm[1]);
    }
}