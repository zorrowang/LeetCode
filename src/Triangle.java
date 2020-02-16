// Totally using O(n) (n is #rows) to get bonus points
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[triangle.get(triangle.size()-1).size()];
        for (int i=0; i<ret.length; i++)
            ret[i] = triangle.get(triangle.size()-1).get(i);
            
        for (int i=triangle.size()-2; i>=0; i--){
            for (int j=0; j<triangle.get(i).size(); j++){
                ret[j] = Math.min(ret[j], ret[j+1])+triangle.get(i).get(j);
            }
        }
        
        return ret[0];
    }
}

// Top-down solution using O(n) space
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[triangle.size()];
        for(int i=0; i<triangle.size(); i++){
            ArrayList<Integer> list = triangle.get(i);
            for(int j=list.size()-1; j>=0; j--){
                if (j==0)
                    ret[j] = ret[j]+list.get(j);
                else if (j==list.size()-1)
                    ret[j] = ret[j-1]+list.get(j);
                else 
                    ret[j] = Math.min(ret[j-1], ret[j])+list.get(j);
            }
        }
        
        int min = ret[0];
        for (int i=1; i<ret.length; i++)
            min = Math.min(min, ret[i]);
        return min;
    }
}