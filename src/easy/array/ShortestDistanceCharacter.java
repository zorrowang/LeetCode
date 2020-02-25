package src.easy.array;

import java.util.Arrays;

class Solution {
    public int[] shortestToChar(String S, char C) {
        // Min array from left to right
        int[] left = new int[S.length()];   Arrays.fill(left, Integer.MAX_VALUE);
        // Min array from right to left
        int[] right = new int[S.length()];  Arrays.fill(right, Integer.MAX_VALUE);
        int[] ret = new int[S.length()];
        
        int currentLeft = -1, currentRight = -1;
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == C) {
                currentLeft = i;
                left[i] = 0;
            } else if (currentLeft != -1) {
                left[i] = i-currentLeft;
            }
            if (S.charAt(S.length()-i-1) == C) {
                currentRight = S.length()-i-1;
                right[S.length()-i-1] = 0;
            } else if (currentRight != -1) {
                right[S.length()-i-1] = currentRight-S.length()+i+1;
            }
        }
        
        for (int i=0; i<ret.length; i++)
            ret[i] = Math.min(left[i], right[i]);
        return ret;
    }
}