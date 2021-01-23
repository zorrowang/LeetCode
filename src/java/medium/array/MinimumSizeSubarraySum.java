package src.java.medium.array;

public class MinimumSizeSubarraySum {
    // Rewritten on 2021/01/21
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j = 0, sum = 0;
        int ret = 0;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s && i < j) {
                ret = ret == 0 ? j-i : Math.min(ret, j-i);
                sum -= nums[i++];
            }
        }
        return ret;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        if (nums==null || nums.length==0 || s==0)   return 0;
        int sum = 0, ret = Integer.MAX_VALUE;
        for (int i=0, j=0; i<nums.length; i++) {
            sum += nums[i];
            while(j<i && sum-nums[j]>=s) {
                sum -= nums[j++];
            }
            if (sum >= s)
                ret = Math.min(ret, i-j+1);
        }
        return ret==Integer.MAX_VALUE?0:ret;
    }
}