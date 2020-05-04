package src.java.easy.dp;

public class DivisorGame {
    public boolean divisorGame(int N) {
        // dp[n] = any{!dp[n-x] | 0<x<n and n%x==0}
        boolean[] dp = new boolean[N+1];
        for (int i=2; i<=N; i++) {
            for (int j=i-1; j>0; j--) {
                if (i%j==0 && !dp[i-j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}