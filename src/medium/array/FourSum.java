package src.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (num==null || num.length<4)  return ret;
        
        Arrays.sort(num);
        
        for (int i=0; i<num.length-3; i++){
            if (i>0 && num[i-1]==num[i])    continue;
            for (int j=i+1; j<num.length-2; j++){
                if (j>i+1 && num[j-1]==num[j])  continue;
                int sum1 = num[i]+num[j];
                int n = target-sum1;
                int s=j+1, t=num.length-1;
                while(s < t){
                    int sum2 = num[s] + num[t]; 
                    if (sum2 < n)    s++;
                    else if (sum2 > n)  t--;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[s++]);
                        list.add(num[t--]);
                        ret.add(list);
                        while (num[s]==num[s-1] && s<t)   s++;
                        while (num[t]==num[t+1] && s<t)   t--;
                    }
                }
            }
        }
        return ret;
    }
}

