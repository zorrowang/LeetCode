public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (n<k)    return ret;
        if(k==1){
            for(int i=1; i<=n; i++){
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                ret.add(l);
            }
            return ret;
        }
        
        for(int i=n; i>=k; i--){
            ArrayList<ArrayList<Integer>> list = combine(i-1, k-1);
            for(ArrayList<Integer> t : list)
                t.add(i);
            ret.addAll(list);
        }
        
        return ret;
    }
}

