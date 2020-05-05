package src.java.medium.dp;

import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++)
            sum += nums[i];
        if (sum%2 == 1)
            return false;
        
        boolean[] check = new boolean[sum/2+1];
        check[0] = true;
        for (int i=0; i<nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<check.length-nums[i]; j++) {
                if (check[j])
                    list.add(j+nums[i]);
            }
            for(Integer j : list)
                if (j < check.length)
                    check[j] = true;
        }
        return check[sum/2];
    }
}
