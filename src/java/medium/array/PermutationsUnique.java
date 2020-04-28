package src.java.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsUnique {

    // BFS implementation
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null)   return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        Arrays.sort(num);
        
        for (int i=0; i<num.length; i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
            for (ArrayList<Integer> list : ret){
                for (int j=0; j<=list.size(); j++){
                    if (j>0 && list.get(j-1)==num[i])
                        continue;
                    ArrayList<Integer> l = new ArrayList<Integer>(list);
                    l.add(j, num[i]);
                    if (!set.contains(l)){
                        temp.add(l);
                        set.add(l);
                    }
                }
            }
            ret = temp;
        }
        
        return ret;
    }

    // DFS implementation
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);
        permute(nums, list, used, ret);
        
        return ret;
    }
    
    private void permute(int[] nums, ArrayList<Integer> list, boolean[] used, List<List<Integer>> ret) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && used[i-1])
                continue;
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                permute(nums, list, used, ret);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}