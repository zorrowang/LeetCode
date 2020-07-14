package src.java.hard.greedy;

import java.util.LinkedList;
import java.util.List;

public class PatchingArray {
    // Greedy solution
    // https://www.programcreek.com/2015/01/leetcode-patching-array-java/
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0;
        int i = 0;
     
        while(miss <= n){
            if(i<nums.length && nums[i] <= miss){
                miss = miss + nums[i];
                i++;
            }else{
                miss += miss;
                count++;
            }
        }
     
        return count;
    }


    // Dummy backtracking solution
    public int minPatches2(int[] nums, int n) {
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<nums.length; i++)   list.add(nums[i]);
        for (int i=1; i<=n; i++) {
            if (!check(list, i, 0))     insert(list, i);
        }
        return list.size() - nums.length;
    }
    
    private boolean check(List<Integer> list, int target, int start) {
        if (list.size() <= start || list.get(start) > target)
            return false;
        if (target == 0 || list.get(start) == target)    return true;
        if (check(list, target, start+1))   return true;
        for (int i=start; i<list.size() && list.get(i)<=target; i++) {
            if (check(list, target-list.get(i), i+1))
                return true;
        }
        return false;
    }
    
    private void insert(List<Integer> list, int n) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) > n) {
                list.add(i, n);
                return;
            }
        }
        list.add(n);
    }
}