public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0)  return 0;
        return searchInsertHelper(A, 0, A.length-1, target);
    }
    
    public int searchInsertHelper(int[] A, int start, int end, int target){
        int mid = (start+end)/2;
        if(A[mid]==target)  return mid;
        else if(A[mid]>target){
            if(mid==start)  return mid;
            else return searchInsertHelper(A, start, mid-1, target);
        }
        else{
            if(mid==end)  return mid+1;
            else return searchInsertHelper(A, mid+1, end, target);
        }
    }
}

