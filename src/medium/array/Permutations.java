package src.medium.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Permutations {
    // Backtracking BFS Implementation
    // Recursive solution
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num==null)  return null;
        return permuteHelper(num, 0);
    }
    
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int start){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (start>num.length-1) return ret;
        if(start==num.length-1){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(num[start]);
            ret.add(list);
            return ret;
        }
        
        ArrayList<ArrayList<Integer>> temp = permuteHelper(num, start+1);
        for(ArrayList<Integer> l : temp){
            ret.addAll(permute(l, num[start]));
        }
        
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list, int num){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=list.size(); i++){
            ArrayList<Integer> temp = (ArrayList<Integer>)list.clone();
            temp.add(i, num);
            ret.add(temp);
        }
        return ret;
    }

    //Iterative solution
    public ArrayList<ArrayList<Integer>> permute2(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null)   return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        
        for (int i=0; i<num.length; i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : ret){
                for (int j=0; j<=list.size(); j++){
                    ArrayList<Integer> l = (ArrayList<Integer>)list.clone();
                    l.add(j, num[i]);
                    temp.add(l);
                }
            }
            ret = temp;
        }
        
        return ret;
    }

    // Backtracking DFS Implementation
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        permute(nums, list, used, ret);
        return ret;
    }
    
    private void permute(int[] nums, ArrayList<Integer> list, HashSet<Integer> used, List<List<Integer>> ret) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                list.add(nums[i]);
                permute(nums, list, used, ret);
                list.remove(list.size()-1);
                used.remove(i);
            }
        }
    }
}