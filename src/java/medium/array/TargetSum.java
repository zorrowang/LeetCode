package src.java.medium.array;

public class TargetSum {
    int ret = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S);
        return ret;
    }
    
    private void dfs(int[] nums, int pos, int S) {
        if (pos == nums.length && S == 0) {
            ret++;
            return;
        }
        if (pos == nums.length)   return;
        dfs(nums, pos + 1, S + nums[pos]);
        dfs(nums, pos + 1, S - nums[pos]);
    }
}