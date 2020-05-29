package src.java.medium.array;

public class FindFirstLastPositionElementSortedArray {
        public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = leftSearch(nums, target);
        ret[1] = rightSearch(nums, target);
        return ret;
    }
    
    private int leftSearch(int[] nums, int t) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = (left + right)/2;
            if (nums[mid]<t) {
                left = mid+1;
            } else if (nums[mid]>t || (nums[mid]==t && mid>0 && nums[mid-1]==t)) {
                right = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    private int rightSearch(int[] nums, int t) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = (left + right)/2;
            if (nums[mid]<t || (nums[mid]==t && mid < nums.length-1 && nums[mid+1]==t)) {
                left = mid+1;
            } else if (nums[mid]>t) {
                right = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}