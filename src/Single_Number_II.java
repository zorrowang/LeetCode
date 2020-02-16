public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashSet<Integer> set = new HashSet<Integer>();
        long sum = 0;
        for(int i=0; i<A.length; i++){
            if (!set.contains(A[i]))
                set.add(A[i]);
            sum += A[i];
        }
        
        if(set.size()==1)
            return A[0];
        for(Integer i: set)
            sum -= (((long)i)*3);
        return (int)(0-sum/2);
    }
}

public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] ret = new int[32];
        int num = 0;
        for(int i=31; i>=0; i--){
            for(int j=0; j<A.length; j++){
                if (((A[j]>>i)&1) == 1){
                    ret[i]++;
                }
            }
            ret[i] %= 3;
            num <<= 1;
            num = num|ret[i];
        }
        return num;
    }
}