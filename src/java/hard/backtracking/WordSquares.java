package src.java.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List<List<String>> ret = new ArrayList<>();
        dfs(words, 0, new ArrayList<>(), ret);
        return ret;
    }
    
    private void dfs(String[] words, int cur, List<String> list, List<List<String>> ret) {
        if (list.size()>0 && list.size()==list.get(0).length()) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<words.length; i++) {
            String s = words[i];
            if (list.isEmpty() || isValid(list, s)) {
                list.add(s);
                dfs(words, i+1, list, ret);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isValid(List<String> list, String s) {
        if (list.get(0).length() != s.length() || list.size() >= s.length())
            return false;
        for (int i=0; i<s.length() && i<list.size(); i++) {
            if (s.charAt(i) != list.get(i).charAt(list.size()))
                return false;
        }
        return true;
    }
}