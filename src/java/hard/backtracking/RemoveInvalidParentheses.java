package src.java.hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        for (int i=0; i<chars.length; i++) {
            if (chars[i]=='(')  left++;
            else if (chars[i]==')') {
                if (left > 0)   left--;
                else    right++;
            }
        }
        
        Set<String> ret = new HashSet<>();
        dfs(chars, 0, left, right, new ArrayList<>(), ret);
        return new ArrayList<>(ret);
    }
    
    private void dfs(char[] chars, int cur, int left, int right, List<Integer> removals, Set<String> ret) {
        if (left==0 && right==0 && isValid(chars, removals)) {
            ret.add(build(chars, removals));
            return;
        }
        if (cur >= chars.length)    return;
        dfs(chars, cur+1, left, right, removals, ret);
        if (chars[cur]=='(' && left>0) {
            removals.add(cur);
            dfs(chars, cur+1, left-1, right, removals, ret);
            removals.remove(removals.size()-1);
        }
        else if (chars[cur]==')' && right>0) {
            removals.add(cur);
            dfs(chars, cur+1, left, right-1, removals, ret);
            removals.remove(removals.size()-1);
        }
    }
    
    private boolean isValid(char[] chars, List<Integer> removals) {
        int left = 0;
        for (int i=0; i<chars.length; i++) {
            if (removals.contains(i))   continue;
            if (chars[i]=='(')  left++;
            else if (chars[i]==')') {
                if (left > 0)   left--;
                else    return false;
            }
        }
        return left==0;
    }
    
    private String build(char[] chars, List<Integer> removals) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            if (removals.contains(i))   continue;
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}