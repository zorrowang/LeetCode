public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null)    return false;
        return searchHelper(A, target, 0, A.length-1);
    }
    
    public boolean searchHelper(int[] A, int target, int start, int end){
        if (start>end)  return false;
        int mid = (start+end)/2;
        if (A[mid]==target) return true;
        else if (A[mid]>target){
            if (A[start]==A[end])
                return searchHelper(A, target, start+1, end);
                
            if (A[start]>target && A[mid]>A[end])
                return searchHelper(A, target, mid+1, end);
            else
                return searchHelper(A, target, start, mid-1);                
        }
        else{
            if (A[start]==A[end])
                return searchHelper(A, target, start+1, end);
                
            if (A[end]<target && A[start]>A[mid])
                return searchHelper(A, target, start, mid-1); 
            else
                return searchHelper(A, target, mid+1, end);
        }
    }
}