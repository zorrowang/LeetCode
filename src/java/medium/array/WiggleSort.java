package src.java.medium.array;

public class WiggleSort {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        if (nums==null || nums.length<=1)   return;
        for (int i=1; i<nums.length; i++) {
            if (i%2==1) {
                if (nums[i-1] > nums[i])    swap(nums, i-1, i);
            } else {
                if (nums[i-1] < nums[i])    swap(nums, i-1, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}