public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
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