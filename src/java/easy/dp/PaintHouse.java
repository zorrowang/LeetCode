package src.java.easy.dp;

public class PaintHouse {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs==null || costs.length==0) return 0;
        int[][] dp = new int[costs.length][3];
        System.arraycopy(costs[0], 0, dp[0], 0, 3);
        for (int i=1; i<costs.length; i++) {
            for (int j=0; j<3; j++) {
                if (j==0)
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][j];
                else if (j==1)
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][j];
                else
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][0]) + costs[i][j];
            }
        }
        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
    }
}