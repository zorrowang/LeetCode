package src.java.medium.math;

import java.util.Random;

public class ShuffleAnArray {
    private int[] nums;
    private int[] origin;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.origin = nums.clone();
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        return nums;
    }
}
