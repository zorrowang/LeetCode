package src.java.easy.array;

import java.util.HashMap;

public class LongestHarmoniousSubsequence {
  public int findLHS(int[] nums) {
    if (nums==null || nums.length==0)
        return 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i=0; i<nums.length; i++)
        map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
    
    int ret = 0;
    for (int key : map.keySet()) {
        if (map.containsKey(key+1))
            ret = Math.max(ret, map.get(key+1) + map.get(key));
    }
    return ret;
}
}