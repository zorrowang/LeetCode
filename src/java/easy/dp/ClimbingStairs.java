package src.java.easy.dp;

public class ClimbingStairs {
    // Standard 1D DP solution
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1; i<=n; i++) {
            dp[i] += dp[i-1];
            if (i > 1)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }

    // Space: O(1)
    public int climbStairs2(int n) {
        if (n<=0)   return 0;
        if (n==1)   return 1;
        if (n==2)   return 2;
        int a=1, b=2;
        while(n>2){
            int temp = b;
            b = a+b;
            a=temp;
            n--;
        }
        return b;
    }
}