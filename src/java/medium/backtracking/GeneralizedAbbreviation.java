package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneralizedAbbreviation {
    /**
     * @param word: the given word
     * @return: the generalized abbreviations of a word
     */
    public List<String> generateAbbreviations(String word) {
        // Write your code here
        List<String> ret = new ArrayList<>();
        if (word==null || word.isEmpty())   return ret;
        dfs(word, ret, "", 0, 0);
        return ret;
    }
    
    private void dfs(String word, List<String> ret, String path, int cnt, int pos) {
        if (pos == word.length()) {
            if (cnt > 0)    path = path + cnt;
            ret.add(path);
            return;
        }
        dfs(word, ret, path, cnt+1, pos+1);
        dfs(word, ret, path + (cnt>0?cnt:"") + word.charAt(pos), 0, pos+1);
    }

    /**
     * TLE
     * @param word: the given word
     * @return: the generalized abbreviations of a word
     */
    public List<String> generateAbbreviations2(String word) {
        // Write your code here
        if (word==null || word.isEmpty())
            return new ArrayList<>();
        return rec(word, 0, word.length()-1);
    }
    
    private List<String> rec(String word, int lo, int hi) {
        if (lo == hi) {
            return Arrays.asList("1", String.valueOf(word.charAt(lo)));
        }
        
        Set<String> set = new HashSet<>();
        for (int i=lo; i<hi; i++) {
            List<String> l1 = rec(word, lo, i);
            List<String> l2 = rec(word, i+1, hi);
            for (String s1 : l1) {
                for (String s2 : l2) {
                    set.add(merge(s1, s2));
                }
            }
        }
        return new ArrayList<>(set);
    }
    
    private String merge(String s1, String s2) {
        int i1 = s1.length()-1, i2 = 0;
        while (i1>=0 && Character.isDigit(s1.charAt(i1)))
            i1--;
        while (i2<s2.length() && Character.isDigit(s2.charAt(i2)))
            i2++;
        if (i1 < s1.length()-1 && i2 > 0) {
            String left = "", right = "";
            int n1 = 0, n2 = 0;
            if (i1>=0) {
                left = s1.substring(0, i1+1);
                n1 = Integer.parseInt(s1.substring(i1+1));
            } else 
                n1 = Integer.parseInt(s1);
            if (i2 < s2.length()) {
                right = s2.substring(i2);
                n2 = Integer.parseInt(s2.substring(0, i2));
            } else
                n2 = Integer.parseInt(s2);
            int n = n1 + n2;
            return left + n + right;
        } else
            return s1 + s2;
    }
}