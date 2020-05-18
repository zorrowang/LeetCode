package src.java.easy.dp;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0, pre = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                pre++;
                ret = Math.max(ret, pre);
            } else
                pre = 0;
        }
        return ret;
    }
}