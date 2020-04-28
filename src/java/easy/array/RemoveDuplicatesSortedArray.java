package src.java.easy.array;

class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length==0) return 0;
        
        int length=0, cur=1;
        while(cur<A.length){
            if (A[cur]!=A[length])
                A[++length] = A[cur++];
            else
                cur++;
        }
        return length+1;
    }
}