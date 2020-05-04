package src.java.medium.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // dp[i] = max{dp[j]+1 | j<i && nums[i] < nums[j]}
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ret = nums.length==0 ? 0 : 1;
        for (int i=1; i<nums.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}