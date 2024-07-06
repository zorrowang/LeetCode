package src.java.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums==null || nums.length<3) return ret;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if (i>0 && nums[i]==nums[i-1])  continue;
            int temp = 0-nums[i];
            int j=i+1, k=nums.length-1;
            while(j<k){
                int n = nums[j]+nums[k];
                if (n>temp) k--;
                else if(n<temp) j++;
                else{
                    ret.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (nums[j-1]==nums[j]&&j<k)
                        j++;
                    while (nums[k+1]==nums[k]&&j<k)
                        k--;
                }
            }
        }
        return ret;
    }
}