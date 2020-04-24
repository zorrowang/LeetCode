package src.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        combinationSum2(candidates, target, 0, list, ret);
        return ret;
    }
    
    private void combinationSum2(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ret) {
        if (target == 0) {
            List<Integer> l = new ArrayList<>(list);
            ret.add(l);
            return;
        }
        
        for (int i=start; i<candidates.length && candidates[i]<=target; i++) {
            if (i>start && candidates[i]==candidates[i-1])
                continue;
            list.add(candidates[i]);
            combinationSum2(candidates, target-candidates[i], i+1, list, ret);
            list.remove(list.size()-1);
        }
    }

    // Legacy
    public ArrayList<ArrayList<Integer>> combinationSum2Legacy(int[] candidates, int target) {
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
            if (i>start && candidates[i]==candidates[i-1])  continue;
            if (candidates[i] == target){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(target);
                ret.add(list);
            }
            else if (candidates[i] < target){
                ArrayList<ArrayList<Integer>> temp = combinationSum(candidates, i+1, target-candidates[i]);
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