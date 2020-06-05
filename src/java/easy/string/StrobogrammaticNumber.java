package src.java.easy.string;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here
        int i=0, j=num.length()-1;
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');  map.put('1', '1');  map.put('8', '8');
        map.put('6', '9');  map.put('9', '6');
        while(i < j) {
            if (map.containsKey(num.charAt(i)) && map.get(num.charAt(i))!=num.charAt(j))
                return false;
            i++;
            j--;
        }
    
        if (i == j)
            return num.charAt(i)=='0' || num.charAt(i)=='1' || num.charAt(i)=='8';
        return true;
    }
}