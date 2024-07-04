package src.java.medium.math;

class MinimumMoves {
    // Initial solution
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        if (max == min) return 0;
        int diff = max - min;
        int ret = diff;
        while (true) {
            int sqr = (min + ret) * nums.length;
            if (ret * (nums.length - 1) == sqr - sum)
                return ret;
            ret++;
        }
    }

    // Updated solution
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        if (max == min) return 0;
        return sum - min * nums.length;
    }
}