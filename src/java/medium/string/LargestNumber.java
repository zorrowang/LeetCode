package src.java.medium.string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums==null || nums.length==0) return "";
        Integer[] numbers = new Integer[nums.length];
        for (int i=0; i<numbers.length; i++)
            numbers[i] = new Integer(nums[i]);
        
        Arrays.sort(numbers, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                if (i1==i2) return 0;
                StringBuilder str1 = new StringBuilder();
                StringBuilder str2 = new StringBuilder();
                str1.append(i1.toString());
                str1.append(i2.toString());
                str2.append(i2.toString());
                str2.append(i1.toString());
                
                char[] array1 = str1.toString().toCharArray();
                char[] array2 = str2.toString().toCharArray();
                
                for(int i=0; i<array1.length; i++){
                    if (array1[i] > array2[i])
                        return -1;
                    else if (array1[i] < array2[i])
                        return 1;
                }
                return 0;
            }
        });
        
        StringBuilder builder = new StringBuilder();
        for (Integer n : numbers)   builder.append(n);
        if (builder.charAt(0) == '0')   return "0";
        else    return builder.toString();
    }
}