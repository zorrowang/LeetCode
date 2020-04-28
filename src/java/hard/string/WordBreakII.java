package src.java.hard.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<>();
        // DP memorization
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        // Directed graph from the end of current string to the end of previous one
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                String str = s.substring(j, i);
                if (wordDict.contains(str) && dp[j]) {
                    dp[i] = true;
                    if (map.containsKey(i))
                        map.get(i).add(j);
                    else
                        map.put(i, new ArrayList(Arrays.asList(j)));
                }
            }
        }
        
        // Quick end if there is no valid result based on DP output
        if(!dp[s.length()]) return ret;
        
        List<Integer> list = new ArrayList<>();
        list.add(s.length());
        build(s, map, ret, list, s.length());
        
        return ret;
    }
    
    // Build the result based on DFS
    public void build(String s, Map<Integer, List<Integer>> map, List<String> ret, List<Integer> list, int cur) {
        if (cur == 0) {
            List<String> temp = new ArrayList<>();
            for (int i=list.size()-1; i>0; i--) 
                temp.add(s.substring(list.get(i), list.get(i-1)));
            ret.add(String.join(" ", temp));
            return;
        }
        
        List<Integer> nexts = map.get(cur);
        for (Integer i : nexts) {
            list.add(i);
            build(s, map, ret, list, i);
            list.remove(i);
        }
    }

    // Backtracking (written in 2018), cannot pass testing (Time Limit Exceeded)
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<>();
        if (s.length()==0)  return ret;
        return helper(s, 0, wordDict);
    }
    
    private List<String> helper(String s, int start, List<String> dict) {
        List<String> ret = new ArrayList<>();
        if (dict.contains(s.substring(start)))  ret.add(s.substring(start));
        for (int i=start+1; i<s.length(); i++) {
            String sub = s.substring(start, i);
            if (dict.contains(sub)) {
                List<String> list = helper(s, i, dict);
                if (list.size() != 0) {
                    for (String str : list)
                        ret.add(sub + " " + str);
                }
            }
        }
        return ret;
    }

    // Original Definition (out-of-date)
    //This solution did not pass stress testing
    public LinkedList<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)
            return null;
        boolean[] breakFlag = new boolean[s.length()+1];
        LinkedList<String>[] ret = new LinkedList[s.length()+1];
        breakFlag[0] = true;
        ret[0] = new LinkedList<String>();
        ret[0].add("");
        
        for (int i=1; i<=s.length(); i++){
            for (int j=0; j<i; j++){
                String sub = s.substring(j,i);
                if (breakFlag[j] && dict.contains(sub)){
                    breakFlag[i] = true;
                    
                    for (String str : ret[j]){
                        StringBuilder temp = new StringBuilder(str);
                        if (temp.length() == 0)   
                            temp.append(sub);
                        else{
                            temp.append(' ');
                            temp.append(sub);
                        }
                        if (ret[i] == null)
                            ret[i] = new LinkedList<String>();
                        ret[i].add(temp.toString());
                    }
                }
            }
        }
        return ret[s.length()];
    }

    
}