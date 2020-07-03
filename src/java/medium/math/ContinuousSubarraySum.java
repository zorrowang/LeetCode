package src.java.medium.math;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            int cnt = 0;
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == 0)   cnt++;
                else                cnt = 0;
                if (cnt >= 2)   return true;
            }
            return false;
        }
        k = Math.abs(k);
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            int mod = nums[i] % k;
            if (set.contains((k - mod) % k))  return true;
            Set<Integer> t = new HashSet<>();
            for (Integer s : set)   t.add((s + mod) % k);
            t.add(mod);
            set = t;
        }
        return false;
    }
}