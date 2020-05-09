package src.java.easy.dp;

public class PaintFence {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        int[] dp = new int[n+1];
        dp[1] = k;
        int same = 0, diff = k; 
        for (int i=2; i<=n; i++) {
            same = diff;
            diff = dp[i-1] * (k-1);
            dp[i] = same + diff;
        }
        return dp[n];
    }
}