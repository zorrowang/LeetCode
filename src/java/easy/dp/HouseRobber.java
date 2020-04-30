package src.java.easy.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int ret = 0;
        for (int i=0; i<nums.length; i++) {
            int pre1 = 0, pre2 = 0;
            if (i-2>=0) pre1 = dp[i-2];
            if (i-3>=0) pre2 = dp[i-3];
            dp[i] = Math.max(pre1, pre2) + nums[i];
            ret = Math.max(ret, dp[i]);
        } 
        return ret;
    }
}