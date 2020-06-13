package src.java.medium.dp;

public class BestTimeBuySellStockWithCooldown {
    // dp[i] = max profit between 0 and i-th elements
    // dp[i] = max{dp[t-1] + (prices[j] - prices[t+1])}
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)   return 0;
        int[] dp = new int[prices.length];
        for (int i=1; i<prices.length; i++) {
            for (int j=i-1; j>=0; j--) {
                dp[i] = Math.max(dp[i], dp[j]);
                int profit = Math.max(prices[i]-prices[j], 0);
                if (j-2>=0) profit += dp[j-2];
                dp[i] = Math.max(dp[i], profit);
            }
        }
        return dp[dp.length-1];
    }
}