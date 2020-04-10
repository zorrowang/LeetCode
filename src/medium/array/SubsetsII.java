package src.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    // BFS implementation
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums==null) return null;
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length; i++){
            List<List<Integer>> list = new ArrayList<>();
            for(List<Integer> l : ret){
                list.add(new ArrayList<Integer>(l));
                l.add(nums[i]);
            }
            
            // If the num is duplicate, we only add the list without this number here
            if (i>0 && nums[i]==nums[i-1]){
                for(List<Integer> l : list){
                    if(l.lastIndexOf(nums[i])==-1)
                        ret.add(l);
                }
            }
            else{
                ret.addAll(list);
            }
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            ret.add(temp);
        }
        ret.add(new ArrayList<Integer>());
        
        return ret;
    }

    // DFS implementation
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        Arrays.sort(nums);
        subsets(nums, 0, list, used, ret);
        return ret;
    }
    
    private void subsets(int[] nums, int start, List<Integer> list, boolean[] used, List<List<Integer>> ret) {       
        ret.add(new ArrayList<>(list));
        for (int i=start; i<nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            list.add(nums[i]);
            used[i] = true;
            subsets(nums, i+1, list, used, ret);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}

