package src.java.medium.string;

public class TernaryExpressionParser {
    /**
     * @param expression: a string, denote the ternary expression
     * @return: a string
     */
    public String parseTernary(String expression) {
        // write your code here
        if (!expression.contains("?"))  return expression;
        int cnt = 1;
        int i = 2;
        while (i<expression.length() && cnt != 0) {
            char c = expression.charAt(i++);
            if (c == '?')   cnt++;
            if (c == ':')   cnt--;
        }
        if (expression.charAt(0) == 'T')    
            return parseTernary(expression.substring(2, i-1));
        else
            return parseTernary(expression.substring(i));
    }
}