package src.java.hard.dp;

public class PaintHouseII {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     * 
     * dp[i][j] = total min cost of painting i-th house with j-th color
     * dp[i][j] = min{ dp[i-1][t] } + cost[i][j] | t != j
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length==0)   return 0;
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i<n; i++)
            dp[0][i] = costs[0][i];
        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                for (int t=0; t<n; t++) {
                    if (t==j)   continue;
                    if (dp[i][j]==0) dp[i][j] = dp[i-1][t] + costs[i][j];
                    else dp[i][j] = Math.min(dp[i][j], dp[i-1][t] + costs[i][j]);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i=0; i<n; i++)
            ret = Math.min(ret, dp[m-1][i]);
        return ret;
    }
}