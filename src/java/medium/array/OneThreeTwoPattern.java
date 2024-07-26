package src.java.medium.array;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0)   return false;
        int[] minLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        minLeft[0] = nums[0];
        minRight[nums.length-1] = nums[nums.length-1];
        for (int i=1; i<nums.length; i++) {
            minLeft[i] = Math.min(nums[i-1], minLeft[i-1]);
        }
        for (int i=nums.length-2; i>=0; i--) {
            int min = nums[i+1];
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[i] && nums[j] > min)
                    min = nums[j];
            }
            minRight[i] = min;
        }
        for (int i=1; i<nums.length-1; i++)
            if (minLeft[i] < nums[i] && minLeft[i] < minRight[i] && nums[i] > minRight[i])
                return true;
        return false;
    }
}
