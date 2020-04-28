package src.java.medium.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i=1; i<triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            // Trick is from last to first
            // It helps to reserve the number in previous round
            for (int j=list.size()-1; j>=0; j--) {
                if (j==0)
                    dp[j] += list.get(j);
                else if (j==list.size()-1)
                    dp[j] = dp[j-1]+list.get(j); 
                else
                    dp[j] = Math.min(dp[j-1], dp[j])+list.get(j);
            }
        }
        int ret = dp[0];
        for (int i=1; i<dp.length; i++)
            ret = Math.min(ret, dp[i]);
        return ret;
    }

    // Legacy
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[triangle.get(triangle.size()-1).size()];
        for (int i=0; i<ret.length; i++)
            ret[i] = triangle.get(triangle.size()-1).get(i);
            
        for (int i=triangle.size()-2; i>=0; i--){
            for (int j=0; j<triangle.get(i).size(); j++){
                ret[j] = Math.min(ret[j], ret[j+1])+triangle.get(i).get(j);
            }
        }
        
        return ret[0];
    }
}