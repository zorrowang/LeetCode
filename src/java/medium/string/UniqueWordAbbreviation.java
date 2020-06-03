package src.java.medium.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {
    Map<String, Set<String>> map;
    /*
    * @param dictionary: a list of words
    */public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        map = new HashMap<>();
        for(String s : dictionary) {
            String str = null;
            if (s.length() < 2) 
                continue;
            else if (s.length() == 2)
                str = s.charAt(0)+"0"+s.charAt(1);
            else
                str = s.charAt(0)+String.valueOf(s.length()-2)+s.charAt(s.length()-1);
            if (map.containsKey(str))
                map.get(str).add(s);
            else {
                Set<String> set = new HashSet<>();
                set.add(s);
                map.put(str, set);
            }
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        String str = null;
        if (word.length() < 2) 
            return true;
        else if (word.length() == 2) 
            str = word.charAt(0)+"0"+word.charAt(1);
        else
            str = word.charAt(0)+String.valueOf(word.length()-2)+word.charAt(word.length()-1);
        if (map.containsKey(str))
            return map.get(str).size()==1 && map.get(str).contains(word);
        else
            return true;
    }
}