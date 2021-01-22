package src.java.medium.array;

public class MaximumProductSubarray {
    // Optimize space usage
    public int maxProduct(int[] nums) {
        int ret = nums[0];
        int minEnding = nums[0], maxEnding = nums[0];
        for (int i=1; i<nums.length; i++) {
            int min = Math.min(minEnding*nums[i], maxEnding*nums[i]);
            int max = Math.max(minEnding*nums[i], maxEnding*nums[i]);
            minEnding = Math.min(nums[i], min);
            maxEnding = Math.max(nums[i], max);
            ret = Math.max(ret, maxEnding);
        }
        return ret;
    }

    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int ret = nums[0];
        int[] maxProductEndHere = new int[nums.length];
        int[] minProductEndHere = new int[nums.length];
        maxProductEndHere[0] = nums[0];
        minProductEndHere[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            maxProductEndHere[i] = Math.max(Math.max(maxProductEndHere[i-1]*nums[i], minProductEndHere[i-1]*nums[i]), nums[i]);
            minProductEndHere[i] = Math.min(Math.min(maxProductEndHere[i-1]*nums[i], minProductEndHere[i-1]*nums[i]), nums[i]);
            ret = Math.max(maxProductEndHere[i], ret);
        }
        return ret;
    }
}