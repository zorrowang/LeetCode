public class Solution {
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
}

