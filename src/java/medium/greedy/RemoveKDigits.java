package src.java.medium.greedy;

import java.util.LinkedList;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        int len = num.length(), cnt = k;
        // Remove first zero's
        int lastZero = 0, noneZero = 0;
        for (int i=0; i<len; i++) {
            char c = num.charAt(i);
            if (c == '0')   lastZero = i;
            else            noneZero++;
            if (noneZero > k)  break;
        }
        if (lastZero > 0) {
            noneZero = 0;
            for (int i=0; i<lastZero; i++) {
                char c = num.charAt(i);
                if (c != '0')   noneZero++;
            }
            num = num.substring(lastZero + 1);
            k -= noneZero;
        }
        
        if (num.length() <= k)     return "0";
        
        // Greedy to keep the rest of digits
        for (int i=0; i<num.length(); i++) {
            char c = num.charAt(i);
            while(!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            if (len - stack.size() > cnt)
                stack.push(c);
            else
                k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.insert(0, stack.pop());
        return sb.toString();
    }
}