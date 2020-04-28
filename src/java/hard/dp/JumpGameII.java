package src.java.hard.dp;

public class JumpGameII {
    // Standard 1D DP solution
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length-1; i++) {
            int steps = nums[i];
            for (int j=1; j<=steps && i+j<nums.length; j++) {
                if (dp[i+j]==0)
                    dp[i+j] = dp[i]+1;
                else
                    dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[dp.length-1];
    }

    // Optimize 1D DP to use constant space
    public int jump2(int[] nums) {
        int curRange=0, nextRange=0;
        int ret=0;
        
        for (int i=0; i<nums.length; i++){
            if (i>curRange){
                curRange = nextRange;
                ret++;
            }
            nextRange = Math.max(nextRange, nums[i]+i);
        }
        
        return ret;
    }
}