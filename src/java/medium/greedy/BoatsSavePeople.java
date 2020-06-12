package src.java.medium.greedy;

import java.util.Arrays;

public class BoatsSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int ret = 0;
        Arrays.sort(people);
        int i=0, j=people.length-1;
        while(i <= j) {
            if (people[i]+people[j] <= limit)   i++;
            j--;
            ret++;
        }
        return ret;
    }
}