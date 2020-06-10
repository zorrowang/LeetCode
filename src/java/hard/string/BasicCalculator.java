package src.java.hard.string;

import java.util.LinkedList;

public class BasicCalculator {
    public int calculate(String s) {
        if (s==null || s.isEmpty()) return 0;
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Integer> parentheses = new LinkedList<>();
        int i = 0, sign = 1;
        while (i<s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int t = i;
                while (i<s.length() && Character.isDigit(s.charAt(i)))
                    i++;
                nums.push(Integer.parseInt(s.substring(t, i)) * sign);
                sign = 1;
                continue;
            } else if (c == '(') {
                if (sign > 0)
                    parentheses.push(i);
                else {
                    parentheses.push(-i);
                    sign = 1;
                }
            } else if (c == ')') {
                int num = 0;
                int index = parentheses.peek();
                while (!parentheses.isEmpty() && index == parentheses.peek()) {
                    num += nums.pop();
                    parentheses.pop();
                }
                if (index >= 0) nums.push(num);
                else    nums.push(-num);
            } else if (c == '+' && !parentheses.isEmpty()) {
                parentheses.push(parentheses.peek());
            } else if (c == '-') {
                sign = -1;
                if (!parentheses.isEmpty())
                    parentheses.push(parentheses.peek());
            }
            i++;
        }
        
        int ret = 0;
        while (!nums.isEmpty()) ret += nums.pop();
        return ret;
    }
}