public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S==null) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        
        for (int i=0; i<S.length; i++){
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            
            for(ArrayList<Integer> l : ret){
                list.add((ArrayList<Integer>)l.clone());
                l.add(S[i]);
            }
            ret.addAll(list);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(S[i]);
            ret.add(temp);
        }
        ret.add(new ArrayList<Integer>());
        
        return ret;
    }
}

