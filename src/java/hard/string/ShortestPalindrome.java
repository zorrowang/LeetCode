package src.java.hard.string;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s==null || s.isEmpty()) return s;
        int i = s.length()-1, max = 0;
        while (i>=0) {
            if (isPalindrome(s, 0, i)) {
                max = i;
                break;
            }
            i--;
        }
        if (max == s.length()-1)  return s;
        return reverse(s, max, s.length()-1);
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    private String reverse(String s, int start, int end) {
        StringBuilder builder = new StringBuilder();
        while (end > start)
            builder.append(s.charAt(end--));
        return builder.toString() + s;
    }
}