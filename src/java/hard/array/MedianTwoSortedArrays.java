package src.java.hard.array;

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1=A.length, l2=B.length;
        if ((l1+l2)%2==0)
            return (findKthElement(A, 0, l1-1, B, 0, l2-1, (l1+l2)/2)+
                findKthElement(A, 0, l1-1, B, 0, l2-1, (l1+l2)/2+1))/2.;
        else
            return findKthElement(A, 0, l1-1, B, 0, l2-1, (l1+l2)/2+1);
    }
    
    public int findKthElement(int A[], int startA, int endA, int[] B, int startB, int endB, int k){
        if (startA>endA)    return B[startB+k-1];
        if (startB>endB)    return A[startA+k-1];
        
        if (k<=1)   return Math.min(A[startA], B[startB]);
        int midA = (startA+endA)/2;
        int midB = (startB+endB)/2;
        if ((midA-startA)+(midB-startB)<k-1){
            if (A[midA]<B[midB]){
                return findKthElement(A, midA+1, endA, B, startB, endB, k-midA+startA-1);
            }
            else{
                return findKthElement(A, startA, endA, B, midB+1, endB, k-midB+startB-1);
            }
        }
        else{
            if (A[midA]<B[midB]){
                return findKthElement(A, startA, endA, B, startB, midB-1, k);
            }
            else{
                return findKthElement(A, startA, midA-1, B, startB, endB, k);
            }
        }
    }
}

