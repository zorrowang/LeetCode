package src.java.medium.array;

public class SearchRotatedSortedArray {
    // Binary search
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    
    private int search(int[] nums, int target, int start, int end) {
        if (start > end)    return -1;
        int mid = start + (end - start)/2;
        if (nums[mid] == target)    return mid;
        else if (nums[mid] > target) {
            if (nums[start] <= target || nums[start] > nums[mid])
                return search(nums, target, start, mid-1);
            else
                return search(nums, target, mid+1, end);
        } else {
            if (nums[end] >= target || nums[end] < nums[mid])
                return search(nums, target, mid+1, end);
            else
                return search(nums, target, start, mid-1);
        }
    }

    // Non-recursive solution, written on 2021/01/17
    public int search4(int[] nums, int target) {
        if (nums==null || nums.length==0)
            return -1;
        
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] > target) {
                if (nums[end] >= nums[mid] || nums[start] <= target)  end = mid-1;
                else    start = mid+1;
            } else if (nums[mid] < target) {
                if (nums[start] <= nums[mid] || nums[end] >= target)   start = mid+1;
                else end = mid-1;
            } else
                return mid;
        }
        return -1;
    }

    // Legacy Solutions
    public int search2(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length==0) return -1; 
        int start = searchHelper(A, 0, A.length-1);
        int ret1 = searchHelper(A, target, 0, start-1);
        int ret2 = searchHelper(A, target, start, A.length-1);
        return ret1==-1?ret2:ret1;
    }
    
    public int searchHelper(int[] A, int target, int start, int end){
        if (start>end)  return -1;
        int mid = (start+end)/2;
        if (A[mid]>target)
            return searchHelper(A, target, start, mid-1);
        else if (A[mid]<target)
            return searchHelper(A, target, mid+1, end);
        else
            return mid;
    }
    
    public int searchHelper(int[] A, int start, int end){
        if (start==end) return start;
        int mid = (start+end)/2;
        if (A[mid]>A[start] && A[mid]>A[end])
            return searchHelper(A, mid+1, end);
        else if (A[mid]<A[start] && A[mid]<A[end]){
            if (mid==0 || (mid>0&&A[mid-1]>A[mid]))
                return mid;
            return searchHelper(A, start, mid-1);
        }
        else
            return A[start]<A[end]?start:end;
    }


    // Solution #3
    public int search3(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null)    return -1;
        return search3(A, target, 0, A.length-1);
    }
    
    public int search3(int[] A, int target, int start, int end){
        if (start>end)  return -1;
        int mid = (start+end)/2;
        if (A[mid]==target) return mid;
        else if (A[mid]>target){
            if (A[start]>target && A[mid]>A[end])
                return searchHelper(A, target, mid+1, end);
            else
                return searchHelper(A, target, start, mid-1);                
        }
        else{
            if (A[end]<target && A[start]>A[mid])
                return searchHelper(A, target, start, mid-1); 
            else
                return searchHelper(A, target, mid+1, end);
        }
    }
}