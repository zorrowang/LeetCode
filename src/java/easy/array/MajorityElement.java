package src.java.easy.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //Moore's voting algorithm
    public int majorityElement(int[] nums) {
        int major_index = 0;
        int count = 1;
        for (int i=1; i<nums.length; i++){
            if (nums[i] == nums[major_index])
                count++;
            else 
                count--;
            if (count == 0){
                major_index = i;
                count = 1;
            }
        }
        return nums[major_index];
    }

    public int majorityElement2(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : num) {
            if (map.containsKey(i)){
                if (map.get(i)+1 > num.length/2)   return i;
                map.put(i, map.get(i)+1);
            }
            else{
                map.put(i, 1);
            }
        }
        return num[0];
    }
}