package src.java.easy.array;

class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cur=0; 
        for (int i=0; i<A.length; i++){
            if (A[i]==elem) continue;
            else{
                A[cur++] = A[i];
            }
        }
        return cur;
    }
}