package src.java.hard.dp;

import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        //dp[i][j] = max scores between i and j
        //dp[i][j] = max{nums[i-1] * nums[k] * nums[j+1] + dp[i][k-1] + dp[k+1][j]}     i<=k<=j
        if (nums==null || nums.length==0)   return 0;
        int len = nums.length;
        int[] arr = new int[len+2];
        Arrays.fill(arr, 1);
        System.arraycopy(nums, 0, arr, 1, len);
        
        int[][] dp = new int[len+2][len+2];
        for (int cur=1; cur<=len; cur++) {
            for (int i=1; i<=len-cur+1; i++) {
                int j = i+cur-1;
                for (int k=i; k<=j; k++) {
                    dp[i][j] = Math.max(dp[i][j], arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j]);
                }
            }
        }
        return dp[1][len];
    }

    
    // Backtracking (DFS): TLE
    public int maxCoins2(int[] nums) {
        if (nums==null || nums.length==0)   return 0;
        return dfs(nums);
    }
    
    private int dfs(int[] nums) {
        if (nums.length==1) return nums[0];
        int ret = 0, len = nums.length;
        for (int i=0; i<len; i++) {
            int[] temp = new int[len-1];
            if (i==0) {
                int product = nums[i]*nums[i+1];
                System.arraycopy(nums, 1, temp, 0, len-1);
                ret = Math.max(dfs(temp) + product, ret);
            } else if (i==len-1) {
                int product = nums[i]*nums[i-1];
                System.arraycopy(nums, 0, temp, 0, len-1);
                ret = Math.max(dfs(temp) + product, ret);
            } else {
                int product = nums[i+1]*nums[i]*nums[i-1];
                System.arraycopy(nums, 0, temp, 0, i);
                System.arraycopy(nums, i+1, temp, i, len-i-1);
                ret = Math.max(dfs(temp) + product, ret);
            }
        }
        return ret;
    }
}