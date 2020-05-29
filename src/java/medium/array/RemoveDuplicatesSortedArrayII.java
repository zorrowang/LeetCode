package src.java.medium.array;

public class RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int cur = 0, count = 0;
        for (int i=0; i<nums.length; i++) {
            if (i==0 || nums[i] != nums[i-1])   count = 1;
            else    count++;
            if (count <= 2) nums[cur++] = nums[i];
        }
        return cur;
    }

    // Legacy solution
    public int removeDuplicates2(int[] A) {
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