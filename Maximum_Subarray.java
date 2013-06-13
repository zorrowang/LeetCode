public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0)  return Integer.MAX_VALUE;
        
        int maxSofar=A[0], maxEndingHere=A[0];
        
        for(int i=1; i<A.length; i++){
            maxEndingHere = Math.max(A[i], maxEndingHere+A[i]);
            maxSofar = Math.max(maxEndingHere, maxSofar);
        }
        
        return maxSofar;
    }
}