package src.java.medium.array;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens==null || tokens.length==0)   return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i=0; i<tokens.length; i++) {
            String t = tokens[i];
            if (Character.isDigit(t.charAt(t.length()-1)))
                stack.push(Integer.parseInt(t));
            else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int ret = 0;
                if (t.equals("+"))  ret = n1+n2;
                else if (t.equals("-"))  ret = n2-n1;
                else if (t.equals("*"))  ret = n1*n2;
                else if (t.equals("/"))  ret = n2/n1;
                stack.push(ret);
            }
        }
        return stack.pop();
    }
}
