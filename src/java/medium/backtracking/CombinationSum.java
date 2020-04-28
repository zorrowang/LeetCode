package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        combinationSum(candidates,target, list, ret);
        return ret;
    }
    
    private void combinationSum(int[] candidates, int target, List<Integer> list, List<List<Integer>> ret) {
        if (target == 0) {
            List<Integer> l = new ArrayList<>(list);
            ret.add(l);
            return;
        }
        
        for (int i=0; i<candidates.length && candidates[i]<=target; i++) {
            // search pruning
            if (!list.isEmpty() && list.get(list.size()-1)>candidates[i])
                continue;
            list.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], list, ret);
            list.remove(list.size()-1);
        }
    }

    // Legacy
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (candidates == null) return null;
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> ret = combinationSum(candidates, 0, target);
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int start, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (int i=start; i<candidates.length; i++){
            if (candidates[i] == target){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(target);
                ret.add(list);
            }
            else if (candidates[i] < target){
                ArrayList<ArrayList<Integer>> temp = combinationSum(candidates, i, target-candidates[i]);
                if (!temp.isEmpty()){
                    for(ArrayList<Integer> list : temp)
                        list.add(0, candidates[i]);
                    ret.addAll(temp);
                }
            } 
            else 
                break;
        }
        return ret;
    }
}