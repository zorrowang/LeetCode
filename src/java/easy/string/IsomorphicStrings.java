package src.java.easy.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s==null || t==null) return false;
        if (s.length() != t.length())   return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)) {
                if (tc != map.get(sc))
                    return false;
            } else {
                if (map.containsValue(tc))
                    return false;
                else
                    map.put(sc, tc);
            }
        }
        return true;
    }
}