package src.java.medium.math;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int ret = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                int s = nums.length-1;
                while (s > j) {
                    if (check(nums[i], nums[j], nums[s])) {
                        ret += s - j;
                        break;
                    }
                    s--;
                }
            }
        }
        return ret;
    }
    
    private boolean check(int n1, int n2, int n3) {
        if (n1+n2 > n3 && n3-n1 < n2)         return true;
        return false;
    }
}