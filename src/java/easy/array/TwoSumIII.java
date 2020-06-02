package src.java.easy.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        map.put(number, map.getOrDefault(number, 0)+1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (Integer i : map.keySet()) {
            if (map.containsKey(value-i)) {
                if (i*2 != value)   return true;
                else return map.get(value-i)>1;
            }
        }
      
}