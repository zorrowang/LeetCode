package src.java.medium.dp;

public class PredictWinner {
    // dp[i][j] = the max scores between i and j
    // dp[i][j] = sum - min{dp[i+1][j], dp[i][j-1]}
    public boolean PredictTheWinner(int[] nums) {
        if (nums==null || nums.length==0)   return false;
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i=0; i<len; i++) {
            dp[i][i] = nums[i];
        }
        int sum = 0;
        for (int i=len-1; i>=0; i--) {
            sum = nums[i];
            for (int j=i+1; j<len; j++) {
                sum += nums[j];
                dp[i][j] = sum - Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len-1] >= sum - dp[0][len-1];
    }
}