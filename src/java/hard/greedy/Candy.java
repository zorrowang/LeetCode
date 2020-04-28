package src.java.hard.greedy;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings==null || ratings.length==0)
            return 0;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        for(int i=1; i<candy.length; i++){
            if (ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }
        }
        
        int ret = candy[candy.length-1];
        for (int i=candy.length-2; i>=0; i--){
            if (ratings[i]>ratings[i+1] && candy[i]<=candy[i+1]){
                candy[i] = candy[i+1]+1;
            }
            ret += candy[i]; 
        }
        
        return ret;
    }
}