public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length==0) return 0;
        int height=0; 
        int left=0, right=A.length-1;
        int ret=0;
        
        while(left<right){
            height = Math.max(height, Math.min(A[left], A[right]));
            ret += height-Math.min(A[left], A[right]);
            if (A[left] > A[right]) right--;
            else    left++;
        }
        
        return ret;
    }
}