package src.easy.array;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        int count=0;
        
        for(int i=0; i<candies.length; i++) {
            if (!set.contains(candies[i])) {
                set.add(candies[i]);
                count++;
                if (count == candies.length/2)
                    break;
            }
        }

        return count;
    }
}