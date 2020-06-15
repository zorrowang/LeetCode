package src.java.hard.backtracking;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        return dfs(pattern, 0, str, 0, new HashMap<>());
    }
    
    private boolean dfs(String pattern, int pos1, String str, int pos2, Map<Character, String> patternMap) {
        if (pos1==pattern.length() && pos2==str.length())   return true;
        if (pos1>=pattern.length() || pos2>=str.length())   return false;
        char pat = pattern.charAt(pos1);
        if (patternMap.containsKey(pat)) {
            String s = patternMap.get(pat);
            if (pos2+s.length() > str.length() || !s.equals(str.substring(pos2, pos2+s.length())))
                return false;
            return dfs(pattern, pos1+1, str, pos2+s.length(), patternMap);
        } else {
            for (int i=pos2+1; i<=str.length(); i++) {
                String match = str.substring(pos2, i);
                if (patternMap.containsValue(match))    continue;
                patternMap.put(pat, match);
                if (dfs(pattern, pos1+1, str, i, patternMap))
                    return true;
                patternMap.remove(pat);
            }
        }
        return false;
    }
}