public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = m+n-1;
        m--;
        n--;
        
        while(n>=0 && m>=0){
            if (A[m]>B[n])
                A[i--] = A[m--];
            else
                A[i--] = B[n--];
        }
        
        while(n>=0)
            A[i--] = B[n--];
    }
}