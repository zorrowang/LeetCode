public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
            
            // If the num is duplicate, we only add the list without this number here
            if (i>0 && S[i]==S[i-1]){
                for(ArrayList<Integer> l : list){
                    if(l.lastIndexOf(S[i])==-1)
                        ret.add(l);
                }
            }
            else{
                ret.addAll(list);
            }
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(S[i]);
            ret.add(temp);
        }
        ret.add(new ArrayList<Integer>());
        
        return ret;
    }
}

