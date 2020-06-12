package src.java.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if (num.isEmpty()) return ret;
        
        char[] path = new char[num.length()*2 - 1];
        char[] digits = num.toCharArray();
        
        long n = 0;
        for (int i=0; i<digits.length; i++) {
            n = n*10 + (digits[i]-'0');
            path[i] = digits[i];
            dfs(ret, path, digits, i+1, i+1, 0, n, target);
            if (n == 0) break;
        }
        return ret;
    }
    
    private void dfs(List<String> ret, char[] path, char[] digits, int pos, int len, long sum, 
                     long cur, int target) {
        if (pos == digits.length) {
            if (sum + cur == target)
                ret.add(new String(path, 0, len));
            return;
        }
        
        int l = len+1;
        long n = 0;
        for (int i=pos; i<digits.length; i++) {
            n = n*10 + (digits[i]-'0');
            path[l++] = digits[i];
            path[len] = '+';
            dfs(ret, path, digits, i+1, l, sum + cur, n, target);
            path[len] = '-';
            dfs(ret, path, digits, i+1, l, sum + cur, -n, target);
            path[len] = '*';
            dfs(ret, path, digits, i+1, l, sum, cur * n, target);
            if (digits[pos] == '0') break;
        }
    }
}