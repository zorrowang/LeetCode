public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length<=1)  return true;
        int maxJump = A[0];
        
        for(int i=1; i<A.length; i++){
            if (maxJump<i)  return false;
            maxJump = Math.max(maxJump, A[i]+i);
        }
        
        return true;
    }
}