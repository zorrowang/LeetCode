package src.medium.dp;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        // comb{i} = sum{comb{i-nums[j]}}
        if (nums==null || nums.length==0)
            return 0;
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        if (target < nums[0])
            return 0;
        
        dp[0] = 1;
        for (int i=nums[0]; i<=target; i++) {
            int count = 0;
            for (int j=0; j<nums.length && nums[j]<=i; j++) {
                count += dp[i-nums[j]];
            }
            dp[i] = count;
        }
        return dp[target];
    }
}