package src.java.hard.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (words.length==0)    return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        int length = words[0].length()*words.length; 
        for (int i=0; i<words.length; i++)
            map.put(words[i], map.getOrDefault(words[i], 1));
        for (int i=0; i+length<=s.length(); i++){
            if (isMatching(s.substring(i, i+length), map, length/words.length))
                ret.add(i);
        }
        return ret;
    }
    
    public boolean isMatching(String s, Map<String, Integer> map, int l){
        StringBuilder sb = new StringBuilder(s); 
        HashMap<String, Integer> tmp = new HashMap<String, Integer>();
        for (int i=0; i+l<=sb.length(); i+=l){
            String str = sb.substring(i, i+l);
            if (map.containsKey(str)){
                if (tmp.containsKey(str)){
                    if (tmp.get(str)>=map.get(str))    return false;
                    else    tmp.put(str, tmp.get(str)+1);        
                }
                else
                    tmp.put(str, 1);
            }
            else
                return false;
        }
        return true;
    }
}