package src.java.easy.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i=0, j=0;
        while(i<nums.length) {
            if (i-j > k)    set.remove(nums[j++]);
            if (set.contains(nums[i]))  return true;
            set.add(nums[i++]);
        }
        return false;
    }
}