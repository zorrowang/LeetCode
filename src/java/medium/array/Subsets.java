package src.java.medium.array;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // BFS
    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null) return null;
        List<List<Integer>> ret = new ArrayList<>();        
        for (int i=0; i<nums.length; i++){
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            
            for(List<Integer> l : ret){
                list.add(new ArrayList<Integer>(l));
                l.add(nums[i]);
            }
            ret.addAll(list);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            ret.add(temp);
        }
        ret.add(new ArrayList<Integer>());
        
        return ret;
    }

    // DFS
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subsets(nums, 0, list, ret);
        return ret;
    }
    
    private void subsets(int[] nums, int start, List<Integer> list, List<List<Integer>> ret) {       
        ret.add(new ArrayList<>(list));
        for (int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i+1, list, ret);
            list.remove(list.size()-1);
        }
    }

    // DFS #2
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, 0, ret);
        return ret;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> ret) {
        if (start == nums.length) {
            List<Integer> l = new ArrayList<>();
            ret.add(l);
            return;
        }
        dfs(nums, start+1, ret);
        int size = ret.size();
        for (int i=0; i<size; i++) {
            List<Integer> l = new ArrayList<>(ret.get(i));
            l.add(nums[start]);
            ret.add(l);
        }
    }
}

