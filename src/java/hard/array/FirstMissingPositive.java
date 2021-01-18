package src.java.hard.array;

public class FirstMissingPositive {
    // Rewritten on 2021/01/18
    public int firstMissingPositive(int[] nums) {
        if (nums==null || nums.length==0)   return 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <=0 || nums[i]>nums.length)
                continue;
            while (nums[i]>0 && nums[i]<=nums.length && nums[i] != i+1 && nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
        }
        for (int i=0; i<nums.length; i++)
            if (nums[i] != i+1) return i+1;
        return nums.length+1;
    }

    public int firstMissingPositive2(int[] A) {
        if (A==null || A.length==0) return 1;
        
        int i=0;
        while(i<A.length){
            if (i==A[i]-1 || A[i]>A.length || A[i]<1 || A[A[i]-1]==A[i])
                i++;
            else
                swap(A, i, A[i]-1);
        }
        
        for(i=0; i<A.length; i++){
            if (i!=A[i]-1)
                return i+1;
        }
        return A.length+1;
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}