package src.java.medium.dp;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n < 0)  return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int cur2 = 0, cur3 = 0, cur5 = 0;
        for (int i=1; i<n; i++) {
            int min = Math.min(dp[cur2]*2, Math.min(dp[cur3]*3, dp[cur5]*5));
            if (min == dp[cur2]*2)  cur2++;
            if (min == dp[cur3]*3)  cur3++;
            if (min == dp[cur5]*5)  cur5++;
            dp[i] = min;
        }
        return dp[n-1];
    }
}