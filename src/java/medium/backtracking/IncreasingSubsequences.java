package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, 0, ret, new ArrayList<>());
        return ret;
    }
    
    private void dfs(int[] nums, int pos, List<List<Integer>> ret, List<Integer> list) {
        if (list.size()>=2)     ret.add(new ArrayList<>(list));
        if (pos >= nums.length)     return;
        for (int i=pos; i<nums.length; i++) {
            if (i>pos && nums[i]==nums[i-1])  continue;
            if (list.isEmpty() || list.get(list.size()-1) <= nums[i]) {
                list.add(nums[i]);
                dfs(nums, i+1, ret, list);
                list.remove(list.size()-1);
            }
        }
    }
}