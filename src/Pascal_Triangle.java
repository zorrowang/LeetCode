public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0)   return ret;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        ret.add(list);
        
        while(numRows>1){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i=0; i<=list.size(); i++){
                if(i==0 || i==list.size())
                    temp.add(1);
                else
                    temp.add(list.get(i-1)+list.get(i));
            }
            ret.add(temp);
            list = temp;
            numRows--;
        }
        
        return ret;
    }
}

