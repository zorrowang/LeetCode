package src.java.hard.stack;

import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s==null || s.isEmpty())    return 0;
        int[] ret = new int[s.length()];
        int max = 0;
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Integer> index = new LinkedList<Integer>();
        
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch=='('){
                stack.push(ch);
                index.push(i);
            }
            else{
                if (stack.isEmpty())    continue;
                stack.pop();
                int in = index.pop();
                int length = i-in+1;
                if (in>0)   length += ret[in-1];
                ret[i] = length;
                max = Math.max(max, length);
            }
        }

        return max;
    }

    // without extra memory
    public int longestValidParentheses2(String s) {
        if (s == null || s.isEmpty())   return 0;
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int p = 0;
            if (s.charAt(i) == ')') p = 1;
            if (st.isEmpty()) {
                st.push(new int[]{p, i});
                continue;
            }
            int[] ar = st.peek();
            if (s.charAt(i) == ')' && ar[0] == 0)   st.pop();
            else    st.push(new int[]{p, i});
        }
        int pre = s.length()-1;
        int max = Integer.MIN_VALUE;
        while (!st.isEmpty()) {
            int[] ar = st.pop();
            max = Math.max(max, pre - ar[1]);
            pre = ar[1] - 1;
        }
        return Math.max(max, pre + 1);
    }
}