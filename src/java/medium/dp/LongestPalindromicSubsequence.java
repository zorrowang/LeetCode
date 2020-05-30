package src.java.medium.dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j] = length of longest palindrome between i-th and j-th
        //          = dp[i+1][j-1] + 2 | s[i]==s[j]
        //          = max{dp[i][j-1], dp[i+1][j]} | s[i]!=s[j]
        if (s==null || s.isEmpty()) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i=0; i<len; i++) {
            Arrays.fill(dp[i], 1);
            if (i>0 && s.charAt(i-1)==s.charAt(i))
                dp[i-1][i] = 2;
        }
        
        for (int i=len-1; i>=0; i--) {
            for (int j=i+2; j<len; j++) {
                if (s.charAt(i)==s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][len-1];
    }
}