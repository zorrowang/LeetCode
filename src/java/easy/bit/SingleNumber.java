package src.java.easy.bit;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    // Bit manipulation solution
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i=0; i<nums.length; i++){
            ret ^= nums[i];
        }
        return ret^0;
    }

    // Hash set solution
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }

        int ret = 0;
        for (Integer i : set)
            ret = i;
        return ret;
    }
}