package src.java.hard.array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A==null || A.length==0) return 1;
        
        int i=0;
        while(i<A.length){
            if (i==A[i]-1 || A[i]>A.length || A[i]<1 || A[A[i]-1]==A[i])
                i++;
            else
                swap(A, i, A[i]-1);
        }
        
        for(i=0; i<A.length; i++){
            if (i!=A[i]-1)
                return i+1;
        }
        return A.length+1;
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}