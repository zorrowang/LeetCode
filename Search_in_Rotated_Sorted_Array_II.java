public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length==0) return false; 
        int start = searchHelper(A, 0, A.length-1);
        boolean ret1 = searchHelper(A, target, 0, start-1);
        boolean ret2 = searchHelper(A, target, start, A.length-1);
        return ret1||ret2;
    }
    
    public boolean searchHelper(int[] A, int target, int start, int end){
        if (start>end)  return false;
        int mid = (start+end)/2;
        if (A[mid]>target)
            return searchHelper(A, target, start, mid-1);
        else if (A[mid]<target)
            return searchHelper(A, target, mid+1, end);
        else
            return true;
    }
    
    public int searchHelper(int[] A, int start, int end){
        if (start>end) return -1;
        if (start==end) return start;
        int mid = (start+end)/2;
        if (A[mid]>A[start] && A[mid]>A[end])
            return searchHelper(A, mid+1, end);
        else if (A[mid]<A[start] && A[mid]<A[end]){
            if (mid==0 || (mid>0&&A[mid-1]>A[mid]))
                return mid;
            return searchHelper(A, start, mid-1);
        }
        else{
            int temp = A[start]<A[end]?start:end;
            if (A[mid] == A[temp]){
                if (A[start]==A[end]){
                    int in1 = searchHelper(A, start, mid-1);
                    int in2 = searchHelper(A, mid+1, end);
                    return in1==-1?in2:(in2==-1?in1:(A[in1]<A[in2]?in1:in2));
                }
                
                if (mid==0 || (mid>0&&mid<temp&&A[mid-1]>A[mid]))
                    return mid;
                else if (mid==A.length-1 || (mid<A.length-1&&mid>temp&&A[mid+1]>A[mid]))
                    return mid;
                else{
                    if (A[start]<A[end])
                        return searchHelper(A, mid+1, end);
                    else
                        return searchHelper(A, start, mid-1);
                }
            }
            else
                return A[start]<A[end]?start:end;
        }
    }
}


