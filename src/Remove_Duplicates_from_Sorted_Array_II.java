public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length==0) return 0;
        
        boolean flag = false;
        
        int length=0, cur=1;
        while(cur<A.length){
            if (A[length]==A[cur] && !flag){
                A[++length] = A[cur++];
                flag = true;
            }
            else if (A[length]==A[cur] && flag)
                cur++;
            else if (A[length]!=A[cur]){
                A[++length] = A[cur++];
                flag = false;
            }
        }
        
        return length+1;
    }
}