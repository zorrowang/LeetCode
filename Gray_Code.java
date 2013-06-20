// http://en.wikipedia.org/wiki/Gray_code
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (n<0)   return ret;
        
        for (int i=0; i<Math.pow(2, n); i++){
            ret.add((i>>1)^i);
        }
        
        return ret;
    }
}

// Reflect-and-prefix method
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (n<0)   return null;
        if (n==0){
            ret.add(0);
            return ret;
        }
        
        ret.add(0);
        ret.add(1);
        for (int i=2; i<=n; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(ret);
            for (int j=ret.size()-1; j>=0; j--){
                temp.add(ret.get(j)|(1<<(i-1)));
            }
            ret = temp;
        }
        
        return ret;
    }
}