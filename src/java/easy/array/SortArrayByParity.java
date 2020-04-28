package src.java.easy.array;

class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] ret = new int[A.length];
        int s = 0, t = A.length-1;
        for (int i=0; i<A.length; i++) {
            if (A[i]%2 == 0)    ret[s++] = A[i];
            else ret[t--] = A[i];
        }
        return ret;
    }

    // In-place solution
    public int[] sortArrayByParityInPlace(int[] A) {
        int s = 0, t = A.length-1;
        while (s < t) {
            if (A[s]%2==1 && A[t]%2==0) {
                int temp = A[s];
                A[s] = A[t];
                A[t] = temp;
            }
            if(A[s]%2==0) s++;
            if(A[t]%2==1) t--;
        }
        return A;
    }
}