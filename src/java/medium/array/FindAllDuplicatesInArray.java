package src.java.medium.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                ret.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return ret;
    }

    // TLE
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            while(nums[i]-1 != i && nums[i] != nums[nums[i]-1]) {
                int t = nums[i];
                nums[i] = nums[t-1];
                nums[t-1] = t;
            }
            if (nums[i]-1 != i && !ret.contains(nums[i]))   
                ret.add(nums[i]);
        }
        return ret;
    }
}