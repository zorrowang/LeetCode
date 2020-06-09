package src.java.medium.array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        int[] ret = new int[len];
        leftToRight[0] = nums[0];
        rightToLeft[len-1] = nums[len-1];
        for (int i=1; i<len; i++) {
            leftToRight[i] = leftToRight[i-1] * nums[i];
            rightToLeft[len-i-1] = rightToLeft[len-i] * nums[len-i-1];
        }
        for (int i=0; i<len; i++) {
            if (i==0)    ret[i] = rightToLeft[i+1];
            else if (i==len-1)  ret[i] = leftToRight[i-1];
            else    ret[i] = rightToLeft[i+1] * leftToRight[i-1];
        }
        return ret;
    }
}