package src.java.medium.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    /**
     * @param n: the length of strobogrammatic number
     * @return: All strobogrammatic numbers
     */
    public List<String> findStrobogrammatic(int n) {
        // write your code here
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        
        List<String> list = helper(n, map);
        List<String> ret = new ArrayList<>();
        for (String str : list) {
            if (str.isEmpty() || str.length() == 1 || (str.length() > 1 && 
                str.charAt(0) != '0'))
                ret.add(str);
        }
        return ret;
    }
    
    private List<String> helper(int n, HashMap<Character, Character> map) {
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            ret.add("");
            return ret;
        }
        if (n==1) {
            ret.add("0");
            ret.add("1");
            ret.add("8");
            return ret;
        }
        
        List<String> list = helper(n-2, map);
        for (String str : list) {
            for (Map.Entry<Character, Character> entry : map.entrySet()) {
                ret.add(entry.getKey() + str + entry.getValue());
            }
        }
        return ret;
    }
}