public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null) return 0;
        int curRange=0, nextRange=0;
        int ret=0;
        
        for (int i=0; i<A.length; i++){
            if (i>curRange){
                curRange = nextRange;
                ret++;
            }
            nextRange = Math.max(nextRange, A[i]+i);
        }
        
        return ret;
    }
}