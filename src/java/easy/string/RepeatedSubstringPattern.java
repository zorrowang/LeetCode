package src.java.easy.string;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s==null || s.isEmpty()) return false;
        int len = s.length();
        int end = 1;
        while (end <= len/2) {
            if (len % end != 0) {
                end++;
                continue;
            }
            if (compare(s, end++))    return true;
        }
        return false;
    }
    
    private boolean compare(String s, int end) {
        String[] arr = s.split(String.format("(?<=\\G.{%d})", end));
        for (int i=1; i<arr.length; i++) {
            if (!arr[0].equals(arr[i]))
                return false;
        }
        return true;
    }
}