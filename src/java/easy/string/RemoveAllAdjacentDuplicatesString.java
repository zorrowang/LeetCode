package src.java.easy.string;

import java.util.LinkedList;

class RemoveAllAdjacentDuplicatesString {
    public String removeDuplicates(String S) {
        if (S==null || S.isEmpty()) return S;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty() || stack.peek() != c)
                stack.push(c);
            else
                stack.pop();
        }
        char[] ret = new char[stack.size()];
        int s = ret.length-1;
        while(!stack.isEmpty()) ret[s--]=stack.pop();
        return String.valueOf(ret);
    }
}
