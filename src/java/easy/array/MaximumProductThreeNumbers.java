package src.java.easy.array;

public class MaximumProductThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            } 

            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2)
                min2 = nums[i];
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}