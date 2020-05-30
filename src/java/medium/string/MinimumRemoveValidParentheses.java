package src.java.medium.string;

import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalids = new HashSet<>();
        int left = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')   left++;
            else if (c == ')') {
                if (left > 0)   left--;
                else invalids.add(i);
            }
        }
        
        int right = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == ')')   right++;
            else if (c == '(') {
                if (right > 0)   right--;
                else invalids.add(i);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (invalids.contains(i))   continue;
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}