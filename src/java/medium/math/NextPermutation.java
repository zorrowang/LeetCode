package src.java.medium.math;

import java.util.Arrays;

// Algorithm:
// #1: from right to left, find the first number which violates the incremental sequence and mark as number 'j'
// #2: from right to left, find the first number which is larger than number 'j', and mark as number 'i'
// #3: swap number i and j
// #4: reverse from i+1 to the end (here I use sort cuz I am too lazy to refactor reverse method)
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2)   return;
        int i=nums.length-1, j=nums.length-2;
        while(j>=0 && nums[i]<=nums[j]){
            i--;
            j--;
        }
        
        if(j<0)
            reverse(nums);
        else{
            i=nums.length-1;
            while(i>j && nums[i]<=nums[j])
                i--;
            swap(nums, i, j);
            Arrays.sort(nums, j+1, nums.length);
        }
            
    }
    
    private void reverse(int[] nums){
        int i=0, j=nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Rewrote on 2021/01/17
    public void nextPermutation2(int[] nums) {
        if (nums==null || nums.length<2)    return;
        int start = nums.length-2;
        // Find the first number not following descending order starting from the end
        while (start >= 0 && nums[start] >= nums[start+1])
            start--;
        reverse(nums, start+1, nums.length-1);
        if (start < 0)  return;
        // Find the smallest number that is larger than the `start` number
        int end = start;
        for (int i=end; i<nums.length; i++) {
            if (nums[i] > nums[start] && (end == start || nums[i] < nums[end]))
                end = i;
        }
        swap(nums, start, end);
    }
    
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i++] = nums[j];
            nums[j--] = t;
        }
    }
}

