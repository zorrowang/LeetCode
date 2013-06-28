public class Solution {
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
                    if (j>0 && list.get(j-1)==num[i])   continue;
                    ArrayList<Integer> l = (ArrayList<Integer>)list.clone();
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
}