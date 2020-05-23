package src.java.medium.array;

public class 3SumSmaller {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        if (nums==null || nums.length==0)   return 0;
        Arrays.sort(nums);
        int ret = 0;
        for (int i=0; i<nums.length-2; i++) {
            ret += helper(nums, i+1, nums.length-1, target-nums[i]);
        }
        return ret;
    }
    
    private int helper(int[] nums, int start, int end, int target) {
        int ret = 0;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                ret += end - start;
                start += 1;
            } else {
                end -= 1;
            }
        }
        return ret;
    }
}