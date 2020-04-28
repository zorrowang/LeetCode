package src.java.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GroupAnagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String>();
        Map<String, LinkedList<String>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            char[] array = str.toCharArray();
            Arrays.sort(array);
            // String signature
            String temp = new String(array);
            if(map.containsKey(temp))
                map.get(temp).add(str);
            else{
                LinkedList<String> list = new LinkedList<String>();
                list.add(str);
                map.put(temp, list);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key).size()>1)
                ret.addAll(map.get(key));
        }
        
        return ret;
    }
}

