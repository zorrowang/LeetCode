package src.java.easy.array;

class SortArrayParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i=0, j=1;
        while (i<A.length) {
            if (A[i]%2 == 0)    i+=2;
            else {
                while(j<A.length && A[j]%2==1)
                    j+=2;
                // Swap
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        return A;
    }
}