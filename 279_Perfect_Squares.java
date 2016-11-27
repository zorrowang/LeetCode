public class Solution {
    public int numSquares(int n) {
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