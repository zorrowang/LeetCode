package src.java.medium.dp;

import java.util.Arrays;

public class PerfectSquares {
    // dp[i] = min(dp[i-j*j])+1
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=1; i*i<=n; i++) 
            dp[i*i] = 1;
        for (int i=2; i<=n; i++) {
            if (dp[i] == 1) continue;
            for (int j=1; j*j<i; j++)
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
        }
        return dp[n];
    }

    // Legacy Solution
    public int numSquares2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            double t = Math.sqrt(i);
            int s = (int)t;
            if (t == s) {
                dp[i] = 1;
                continue;
            }
            for (int j = s; j>0; j--) {
                dp[i] = Math.min(dp[i], dp[i - (int)(Math.pow(j, 2))] + 1);
            }
        }
        return dp[n];
    }
}