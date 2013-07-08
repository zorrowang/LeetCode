public class Solution {
    public int search(int[] A, int target) {
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
}

