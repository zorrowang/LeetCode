public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = binarySearchLeft(A, 0, A.length-1, target);
        int right = binarySearchRight(A, 0, A.length-1, target);
        int[] ret = new int[2];
        ret[0] = left;
        ret[1] = right;
        return ret;
    }
    
    public int binarySearchLeft(int[] A, int start, int end, int target){
        if (start>end)  return -1;
        int mid = (start+end)/2;
        if(A[mid]>target)
            return binarySearchLeft(A, start, mid-1, target);
        else if(A[mid]<target)
            return binarySearchLeft(A, mid+1, end, target);
        else{
            if (mid>0&&A[mid-1]==target)
                return binarySearchLeft(A, start, mid-1, target);
            else
                return mid;
        }
    }
    
    public int binarySearchRight(int[] A, int start, int end, int target){
        if (start>end)  return -1;
        int mid = (start+end)/2;
        if(A[mid]>target)
            return binarySearchRight(A, start, mid-1, target);
        else if(A[mid]<target)
            return binarySearchRight(A, mid+1, end, target);
        else{
            if (mid<A.length-1&&A[mid+1]==target)
                return binarySearchRight(A, mid+1, end, target);
            else
                return mid;
        }
    }
}

