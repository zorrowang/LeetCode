package src.java.medium.dp;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        
        int[] dp = new int[nums.length];
        int ret = 0;
        // include first element, but not the last one
        for (int i=0; i<nums.length-1; i++) {
            int pre1 = 0, pre2 = 0;
            if (i-2>=0) pre1 = dp[i-2];
            if (i-3>=0) pre2 = dp[i-3];
            dp[i] = Math.max(pre1, pre2) + nums[i];
            ret = Math.max(ret, dp[i]);
        } 
        // include the last element, but not the first one
        dp[0] = 0;
        for (int i=1; i<nums.length; i++) {
            int pre1 = 0, pre2 = 0;
            if (i-2>=0) pre1 = dp[i-2];
            if (i-3>=0) pre2 = dp[i-3];
            dp[i] = Math.max(pre1, pre2) + nums[i];
            ret = Math.max(ret, dp[i]);
        } 
        return ret;
    }
}