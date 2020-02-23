package src;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num==null || num.length<3)  return Integer.MAX_VALUE;
        
        Arrays.sort(num);
        int ret = num[0]+num[1]+num[num.length-1];
        
        for (int i=0; i<num.length-2; i++){
            int j=i+1, k=num.length-1;
            while(j<k){
                int temp = num[i]+num[j]+num[k];
                if (temp<target){
                    ret = Math.abs(temp-target)<Math.abs(ret-target)?temp:ret;
                    j++;
                }
                else if (temp>target){
                    ret = Math.abs(temp-target)<Math.abs(ret-target)?temp:ret;
                    k--;
                }
                else
                    return target;
            }
        }
        
        return ret;
    }
}

