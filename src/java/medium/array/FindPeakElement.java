package src.java.medium.array;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }
    
    private int findPeakElement(int[] nums, int start, int end) {
        int mid = start + (end - start)/2;
        boolean left = false, right = false;
        if (mid==0 || nums[mid] > nums[mid-1])
            left = true;
        if (mid==nums.length-1 || nums[mid] > nums[mid+1])
            right = true;
        if (left && right)
            return mid;
        else if (left && !right)
            return findPeakElement(nums, mid+1, end);
        else
            return findPeakElement(nums, start, mid-1);
    }
}