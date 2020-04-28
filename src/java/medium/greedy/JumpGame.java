package src.java.medium.greedy;

public class JumpGame {
    public boolean canJump(int[] A) {
        if(A.length<=1)  return true;
        int maxJump = A[0];
        
        for(int i=1; i<A.length; i++){
            if (maxJump<i)  return false;
            maxJump = Math.max(maxJump, A[i]+i);
        }
        return true;
    }
}