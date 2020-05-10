package src.java.medium.string;

import java.util.LinkedList;

public class ValidParenthesisString {
    // greedy
    public boolean checkValidString(String s) {
        if (s.isEmpty())    return true;
        // '*' matches with '('
        int star = 0, left = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')   left++;
            else if (c == ')') {
                if (left > 0)   left--;
                else if (star > 0) star--;
                else    return false;
            } else  star++;
        }
        if (left > star)   return false;
        
        // '*' matches with ')'
        star = 0;
        int right = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == ')')   right++;
            else if (c == '(') {
                if (right > 0)  right--;
                else if (star > 0) star --;
                else    return false;
            }   else star++;
        }
        if (right > star)   return false;
        
        return true;
    }

    // Greedy #2
    // Let `lo`, `hi` respectively be the smallest and largest possible number of 
    // open left brackets after processing the current character in the string.
    public boolean checkValidString2(String s) {
        int lo = 0, hi = 0;
       for (char c: s.toCharArray()) {
           lo += c == '(' ? 1 : -1;
           hi += c != ')' ? 1 : -1;
           if (hi < 0) return false;
           lo = Math.max(lo, 0);
       }
       return lo == 0;
    }

    // DFS - TLE
    public boolean checkValidStringDfs(String s) {
        return dfs(s, 0, new LinkedList<Character>());
    }
    
    private boolean dfs(String s, int start, LinkedList<Character> stack) {
        if (start==s.length())  return stack.isEmpty();
        char c = s.charAt(start);
        if (c == '(') {
            stack.push(c);
            return dfs(s, start+1, stack);
        } else if (c == ')') {
            if (stack.isEmpty())    return false;
            stack.pop();
            return dfs(s, start+1, stack);
        } else {
            // * = empty 
            LinkedList<Character> temp = new LinkedList<Character>(stack);
            if(dfs(s, start+1, temp)) return true;
            // * = (
            temp = new LinkedList<Character>(stack);
            temp.push('(');
            if(dfs(s, start+1, temp)) return true;
            // * = )
            if (!stack.isEmpty()) {
                temp = new LinkedList<Character>(stack);
                temp.pop();
                if(dfs(s, start+1, temp)) return true;
            } else
                return false;
        }
        return stack.isEmpty();
    }
}