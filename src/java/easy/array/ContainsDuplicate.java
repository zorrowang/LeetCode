package src.java.easy.array;

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums).distinct().count();
    }
}