package src.java.medium.array;

public class SearchRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums==null)    return false;
        return searchHelper(nums, target, 0, nums.length-1);
    }
    
    public boolean searchHelper(int[] nums, int target, int start, int end){
        if (start>end)  return false;
        int mid = (start+end)/2;
        if (nums[mid]==target) return true;
        else if (nums[mid]>target){
            if (nums[start]==nums[end])
                return searchHelper(nums, target, start+1, end);
                
            if (nums[start]>target && nums[mid]>nums[end])
                return searchHelper(nums, target, mid+1, end);
            else
                return searchHelper(nums, target, start, mid-1);                
        }
        else{
            if (nums[start]==nums[end])
                return searchHelper(nums, target, start+1, end);
                
            if (nums[end]<target && nums[start]>nums[mid])
                return searchHelper(nums, target, start, mid-1); 
            else
                return searchHelper(nums, target, mid+1, end);
        }
    }
}