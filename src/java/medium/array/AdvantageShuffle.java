package src.java.medium.array;

import java.util.Arrays;

public class AdvantageShuffle {
    // Find the closest larger number from A respect to the number from B
    public int[] advantageCount(int[] A, int[] B) {
        int[] ret = new int[A.length];
        Arrays.fill(ret, -1);
        
        boolean[] used = new boolean[A.length];
        Arrays.sort(A);
        for (int i=0; i<B.length; i++) {
            int index = search(A, B[i]);
            while (index<A.length && (used[index] || A[index]<=B[i]))
                index++;
            if (index<A.length) {
                ret[i] = A[index];
                used[index] = true;
            }
        }
        
        int j = 0;
        for (int i=0; i<ret.length; i++) {
            if (ret[i] == -1) {
                while (j < A.length && used[j])
                    j++;
                ret[i] = A[j];
                used[j] = true;
            }
        }
        return ret;
    }
    
    private int search(int[] A, int t) {
        int start = 0, end = A.length-1;
        while(start < end) {
            int mid = start + (end-start)/2;
            if (A[mid] == t)    return mid;
            else if (A[mid] > t)    end = mid-1;
            else    start = mid+1;
        }
        return start;
    }
}