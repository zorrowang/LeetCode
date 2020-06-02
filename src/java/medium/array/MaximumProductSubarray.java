package src.java.medium.array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
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