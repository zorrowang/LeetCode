public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i=0; i<A.length; i++){
            if (set.contains(A[i]))
                set.remove(A[i]);
            else
                set.add(A[i]);
        }

        int ret = 0;
        for (Integer i : set)
            ret = i;
        return ret;
    }
}

// Using constant memory
public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int ret = 0;
        for (int i=0; i<A.length; i++){
            ret ^= A[i];
        }

        return ret^0;
    }
}