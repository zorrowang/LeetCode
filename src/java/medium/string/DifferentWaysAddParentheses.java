package src.java.medium.string;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        if (input==null || input.isEmpty()) return ret;
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (Integer i1 : left) {
                    for (Integer i2 : right) {
                        if (c == '+')   ret.add(i1+i2);
                        if (c == '-')   ret.add(i1-i2);
                        if (c == '*')   ret.add(i1*i2);
                    }
                }
            }
        }
        if (ret.isEmpty())  ret.add(Integer.parseInt(input));
        return ret;
    }
}