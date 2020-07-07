package src.java.hard.dp;

public class SplitArrayLargestSum {
    // DP solution

    
    // Recursive solution - TLE
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || nums.length < m)
            return 0;
        return splitArrayHelper(nums, m, 0, nums.length-1);
    }
    
    private int splitArrayHelper(int[] nums, int m, int start, int end) {
        if (m == 1) {
            return sum(nums, start, end);
        }
        int tmp = 0;
        int current = Integer.MAX_VALUE;
        for (int i = start; i <= end-m+1; i++) {
            tmp += nums[i];
            int rest = splitArrayHelper(nums, m-1, i+1, end);
            current = Math.min(current, Math.max(tmp, rest));
        }
        return current;
    }
    
    private int sum(int[] nums, int start, int end) {
        int ret = 0;
        for (; start <= end; start++)
            ret += nums[start];
        return ret;
    }
}