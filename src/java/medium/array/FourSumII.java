package src.java.medium.array;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
    
        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int ret=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                ret += map.getOrDefault(0-A[i]-B[j], 0);
            }
        }

        return ret;
    }
}